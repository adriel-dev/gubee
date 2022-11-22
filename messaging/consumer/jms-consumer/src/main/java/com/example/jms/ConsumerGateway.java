package com.example.jms;

import com.example.port.in.UserMessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@ApplicationScoped
public class ConsumerGateway implements Gateway, Runnable {

    @Inject
    ConnectionFactory connectionFactory;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private List<UserMessageDTO> users = new ArrayList<>();
    private UserMessageDTO lastUser;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<UserMessageDTO> getMessagesList() {
        return users;
    }

    @Override
    public UserMessageDTO getLastMessage() {
        return lastUser;
    }

    private void getMessagesFromQueue() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.CLIENT_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("users"));
            while (true) {
                Message message = consumer.receive();
                if (message == null) return;
                UserMessageDTO messageUser = mapper
                        .readValue(message.getBody(String.class), UserMessageDTO.class);
                users.add(messageUser);
                lastUser = messageUser;
                message.acknowledge();
            }
        } catch (JMSException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    void onStart(@Observes StartupEvent ev) {
        executor.submit(this);
    }

    void onStop(@Observes ShutdownEvent ev) {
        executor.shutdown();
    }

    @Override
    public void run() {
        getMessagesFromQueue();
    }

}
