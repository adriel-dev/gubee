package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserPersistenceAdapter;
import com.adriel.hexagonalexample.user.adapter.out.persistence.stub.UserRepositoryInMemory;
import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UpdateUserControllerTest {

    private UpdateUserController updateUserController;

    @BeforeEach
    void setUp() {
        UserPersistenceAdapter adapter = new UserPersistenceAdapter(new UserRepositoryInMemory());
        updateUserController = new UpdateUserController(adapter);
    }

    @Test
    void shouldUpdateUserAndReturnUser() {
        //given
        Long id = 1L;
        RegisterUserCommand userCommand = new RegisterUserCommand("update und test", "9i4324");
        //when
        var response = updateUserController.updateUser(id, userCommand);
        //then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(id);
        assertThat(response.getBody()).isInstanceOf(User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}