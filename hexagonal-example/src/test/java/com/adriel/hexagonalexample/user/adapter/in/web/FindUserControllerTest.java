package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserPersistenceAdapter;
import com.adriel.hexagonalexample.user.adapter.out.persistence.stub.UserRepositoryInMemory;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

class FindUserControllerTest {

    private FindUserController findUserController;

    @BeforeEach
    void setUp() {
        var adapter = new UserPersistenceAdapter(new UserRepositoryInMemory());
        findUserController = new FindUserController(adapter);
    }

    @Test
    void findUserByIdShouldReturnUser() {
        //given
        Long id = 1L;
        //when
        var response = findUserController.findUserById(id);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getBody()).isInstanceOf(User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findUserByIdShouldThrowException() {
        //given
        Long id = 99L;
        //when
        var response = findUserController.findUserById(id);
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}