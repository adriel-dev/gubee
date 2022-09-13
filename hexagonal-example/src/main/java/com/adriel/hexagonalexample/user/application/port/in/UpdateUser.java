package com.adriel.hexagonalexample.user.application.port.in;

import com.adriel.hexagonalexample.user.domain.User;

public interface UpdateUser {

    User updateUser(Long id, RegisterUserCommand userCommand);

}