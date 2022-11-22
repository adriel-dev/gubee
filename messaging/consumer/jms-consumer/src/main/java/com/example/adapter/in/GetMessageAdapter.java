package com.example.adapter.in;

import com.example.jms.Gateway;
import com.example.port.in.GetMessage;
import com.example.port.in.UserMessageDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetMessageAdapter implements GetMessage {

    @Inject
    Gateway gateway;

    @Override
    public List<UserMessageDTO> getAllMessages() {
        return gateway.getMessagesList();
    }

    @Override
    public UserMessageDTO getLastMessage() {
        return gateway.getLastMessage();
    }
}
