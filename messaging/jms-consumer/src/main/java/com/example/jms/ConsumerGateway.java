package com.example.jms;

import com.example.port.in.UserMessageCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ConsumerGateway implements Gateway {

    @Inject
    ConnectionFactory connectionFactory;

    private final List<UserMessageCommand> users = new ArrayList<>();

    @Override
    public List<UserMessageCommand> getMessages() {
        getMessageFromQueue();
        return users;
    }

    private void getMessageFromQueue() {
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

}