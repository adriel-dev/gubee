package com.example.user.adapter.out.messaging.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;

@ApplicationScoped
public class ProducerGateway implements Gateway {

    @Inject
    ConnectionFactory connectionFactory;

    @Override
    public void sendMessage(Integer userId) {
        try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            Destination destination = context.createQueue("users");
            context.createProducer().send(destination, Integer.toString(userId));
        }
    }
}