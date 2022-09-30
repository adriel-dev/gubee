package com.example.user.adapter.out.messaging.jms;

import com.example.user.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;

@ApplicationScoped
public class ProducerGateway implements Gateway {

    @Inject
    ConnectionFactory connectionFactory;

    @Override
    public void sendMessage(User user) {
        try (JMSContext context = connectionFactory.createContext(JMSContext.CLIENT_ACKNOWLEDGE)) {
            Destination destination = context.createQueue("users");
            context.createProducer().send(destination, new ObjectMapper().writeValueAsString(user.toCommand()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}