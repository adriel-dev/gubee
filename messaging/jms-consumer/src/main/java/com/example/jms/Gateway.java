package com.example.jms;

import com.example.port.in.UserMessageCommand;

import java.util.List;

public interface Gateway {

    public List<UserMessageCommand> getMessages();

}