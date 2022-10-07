package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterUserControllerItTest {

    @Autowired
    private RegisterUserController registerUserController;

    @Test
    void shouldRegisterUserAndReturnUser() {
        //given
        RegisterUserCommand userCommand = new RegisterUserCommand("register test", "7654321");
        //when
        var response = registerUserController.registerUser(userCommand);
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void registerUserShouldThrowException() {
        RegisterUserCommand userCommand = new RegisterUserCommand("register test", "7654321");
    }

}