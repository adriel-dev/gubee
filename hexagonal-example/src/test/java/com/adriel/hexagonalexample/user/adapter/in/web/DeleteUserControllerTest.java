package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserPersistenceAdapter;
import com.adriel.hexagonalexample.user.adapter.out.persistence.UserRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DeleteUserControllerTest {

    private DeleteUserController deleteUserController;

    @BeforeEach
    void setUp() {
        UserPersistenceAdapter adapter = new UserPersistenceAdapter(new UserRepositoryInMemory());
        deleteUserController = new DeleteUserController(adapter);
    }

    @Test
    void shouldDeleteUser() {
        //given
        Long id = 1L;
        //when
        var response = deleteUserController.deleteUser(id);
        //then
        assertThat(response.getBody()).isNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}