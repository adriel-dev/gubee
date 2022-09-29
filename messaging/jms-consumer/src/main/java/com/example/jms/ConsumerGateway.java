package com.example.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;


@ApplicationScoped
public class ConsumerGateway implements Gateway {

    @Inject
    ConnectionFactory connectionFactory;

    private volatile String lastUser;

    @Override
    public String getLastMessage() {
        getMessageFromQueue();
        return lastUser;
    }

    private void getMessageFromQueue() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("users"));
            while (true) {
                Message message = consumer.receive();
                if (message == null) return;
                lastUser = message.getBody(String.class);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}