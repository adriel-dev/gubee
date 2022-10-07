package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UpdateUserControllerItTest {

    @Autowired
    private UpdateUserController updateUserController;

    @Test
    void shouldUpdateUserAndReturnUser() {
        //given
        Long id = 1L;
        RegisterUserCommand userCommand = new RegisterUserCommand("update it test", "IU123");
        //when
        var response = updateUserController.updateUser(id, userCommand);
        //then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isInstanceOf(User.class);
        assertThat(response.getBody().getId()).isEqualTo(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldUpdateUserAndThrowException() {
        //given
        Long id = 99L;
        RegisterUserCommand userCommand = new RegisterUserCommand("update it test", "IU123");
        //when
        var response = updateUserController.updateUser(id, userCommand);
        //then
        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}