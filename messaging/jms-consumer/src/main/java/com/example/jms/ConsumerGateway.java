package com.example.jms;

import com.example.port.in.UserMessageCommand;
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

    private List<UserMessageCommand> users = new ArrayList<>();

    @Override
    public List<UserMessageCommand> getMessages() {
        return users;
    }

    private void getMessagesFromQueue() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.CLIENT_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("users"));
            while (true) {
                Message message = consumer.receive();
                if (message == null) return;
                users.add(new ObjectMapper()
                        .readValue(
                        message.getBody(String.class),
                        UserMessageCommand.class
                        )
                );
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