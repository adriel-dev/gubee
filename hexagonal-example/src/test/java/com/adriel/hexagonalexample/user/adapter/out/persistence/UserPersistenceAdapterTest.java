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

@SpringBootTest
class UserPersistenceAdapterTest {

    @Mock
    private UserRepository userRepository;
    private AutoCloseable autoCloseable;
    private UserPersistenceAdapter adapter;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        adapter = new UserPersistenceAdapter(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void shouldRegisterUser() {
        //given
        RegisterUserCommand userCommand = new RegisterUserCommand("teste", "123");

        //when
        when(userRepository.save(any())).thenReturn(new UserJpa(
                null,
                userCommand.getUsername(),
                userCommand.getPassword()
        ));
        var response = adapter.registerUser(userCommand);

        //then
        verify(userRepository, times(1)).save(any());
        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(User.class);
        assertThat(response.getUsername()).isEqualTo(userCommand.getUsername());
        assertThat(response.getPassword()).isEqualTo(userCommand.getPassword());
    }

    @Test
    void findUserByIdShouldReturnAnUser() {
        //given
        //when
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new UserJpa(
                1L,
                "teste",
                "123"
        )));
        var response = adapter.findUserById(1L);
        //then
        verify(userRepository, times(1)).findById(anyLong());
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
        //when
        doNothing().when(userRepository).deleteById(anyLong());
        adapter.deleteUserById(7L);
        //then
        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void shouldUpdateUserAndReturnUpdatedUser() {
        //given
        Long id = 5L;
        var userCommand = new RegisterUserCommand("teste update", "321");

        //when
        when(userRepository.findById(id)).thenReturn(Optional.of(new UserJpa(
                id,
                "teste",
                "123"
        )));
        when(userRepository.save(any())).thenReturn(new UserJpa(
                id,
                userCommand.getUsername(),
                userCommand.getPassword()
        ));
        var response = adapter.updateUser(id, userCommand);

        //then
        verify(userRepository, times(1)).findById(anyLong());
        verify(userRepository, times(1)).save(any());
        assertThat(response).isNotNull();
        assertThat(response).isInstanceOf(User.class);
        assertThat(response.getUsername()).isEqualTo(userCommand.getUsername());
        assertThat(response.getPassword()).isEqualTo(userCommand.getPassword());
    }

}