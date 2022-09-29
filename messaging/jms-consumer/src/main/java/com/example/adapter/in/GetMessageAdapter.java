package com.example.adapter.in;

import com.example.jms.Gateway;
import com.example.port.in.GetMessage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetMessageAdapter implements GetMessage {

    @Inject
    private Gateway gateway;

    @Override
    public String getLastMessage() {
        return gateway.getLastMessage();
    }

}