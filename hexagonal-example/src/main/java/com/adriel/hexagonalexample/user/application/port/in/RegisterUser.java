package com.adriel.hexagonalexample.user.application.port.in;

import com.adriel.hexagonalexample.user.domain.User;

public interface RegisterUser {

    User registerUser(RegisterUserCommand userCommand);

}