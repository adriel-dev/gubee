package com.example.user.adapter.out.messaging;

import com.example.user.adapter.out.messaging.jms.Gateway;
import com.example.user.domain.User;
import com.example.user.port.in.RegisterUser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserMessagingAdapter implements RegisterUser {

    @Inject
    Gateway gateway;

    @Override
    public void registerUser(User user) {
        user.save();
        gateway.sendMessage(user);
    }

}
