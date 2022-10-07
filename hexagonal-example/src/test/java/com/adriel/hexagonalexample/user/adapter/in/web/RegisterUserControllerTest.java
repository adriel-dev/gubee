package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserPersistenceAdapter;
import com.adriel.hexagonalexample.user.adapter.out.persistence.UserRepositoryInMemory;
import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegisterUserControllerTest {

    private RegisterUserController registerUserController;

    @BeforeEach
    void setUp() {
        UserPersistenceAdapter adapter = new UserPersistenceAdapter(new UserRepositoryInMemory());
        registerUserController = new RegisterUserController(adapter);
    }

    @Test
    void registerUser() {
        //given
        RegisterUserCommand userCommand = new RegisterUserCommand("register und test", "124124");
        //when
        var response = registerUserController.registerUser(userCommand);
        //then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isInstanceOf(User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}