package com.example.jms;

import com.example.port.in.UserMessageDTO;

import java.util.List;

public interface Gateway {

    public List<UserMessageDTO> getMessagesList();
    public UserMessageDTO getLastMessage();

}
