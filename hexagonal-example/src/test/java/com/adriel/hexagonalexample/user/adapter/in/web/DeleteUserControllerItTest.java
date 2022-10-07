package com.adriel.hexagonalexample.user.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteUserControllerItTest {

    @Autowired
    private DeleteUserController deleteUserController;

    @Test
    void deleteUser() {
        //given
        Long id = 1L;
        //when
        var response = deleteUserController.deleteUser(id);
        //then
        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}