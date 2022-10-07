package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class FindUserControllerItTest {

    @Autowired
    private FindUserController findUserController;

    @Test
    void findUserByIdShouldReturnUser() {
        //given
        Long id = 1L;
        //when
        var response = findUserController.findUserById(id);
        //
        assertThat(response).isNotNull();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isInstanceOf(User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findUserByIdShouldReturnNotFound() {
        //given
        Long id = 72L;
        //when
        var response = findUserController.findUserById(id);
        //then
        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}