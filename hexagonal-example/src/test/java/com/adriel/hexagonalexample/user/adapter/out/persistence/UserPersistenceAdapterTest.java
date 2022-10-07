package com.adriel.hexagonalexample.user.adapter.out.persistence;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UserPersistenceAdapterTest {

    private final UserRepositoryInMemory userRepository = new UserRepositoryInMemory();
    private UserPersistenceAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new UserPersistenceAdapter(userRepository);
        adapter.registerUser(new RegisterUserCommand("teste","123"));
    }

    @Test
    void shouldRegisterUser() {
        //given
        RegisterUserCommand userCommand = new RegisterUserCommand("teste", "123");

        //when
        var response = adapter.registerUser(userCommand);

        //then
        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(User.class);
        assertThat(response.getUsername()).isEqualTo(userCommand.getUsername());
        assertThat(response.getPassword()).isEqualTo(userCommand.getPassword());
    }

    @Test
    void findUserByIdShouldReturnAnUser() {
        //given
        //when
        var response = adapter.findUserById(1L);
        //then
        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(User.class);
    }

    @Test
    void findUserByIdShouldThrowException() {
        //given
        Long id = 42L;
        //when
        //then
        assertThatThrownBy(() -> adapter.findUserById(id)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldDeleteUserById() {
        //given
        Long id = 1L;
        //when
        adapter.deleteUserById(id);
        //then
        var res = userRepository.findById(id);
        assertThat(res.isPresent()).isFalse();
    }

    @Test
    void shouldUpdateUserAndReturnUpdatedUser() {
        //given
        Long id = 1L;
        var userCommand = new RegisterUserCommand("teste update", "321");

        //when
        var response = adapter.updateUser(id, userCommand);

        //then
        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(User.class);
        assertThat(response.getUsername()).isEqualTo(userCommand.getUsername());
        assertThat(response.getPassword()).isEqualTo(userCommand.getPassword());
    }

}