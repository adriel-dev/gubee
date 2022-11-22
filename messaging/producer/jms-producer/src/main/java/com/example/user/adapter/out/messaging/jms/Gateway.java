package com.example.user.adapter.out.messaging.jms;

import com.example.user.domain.User;

public interface Gateway {

    public void sendMessage(User user);

}