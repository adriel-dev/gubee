package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.adapter.out.persistence.UserPersistenceAdapter;
import com.adriel.hexagonalexample.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
class FindUserControllerTest {

    @Autowired
    private FindUserController findUserController;

    private AutoCloseable autoCloseable;

    @Mock
    private UserPersistenceAdapter adapter;

    @BeforeEach
    void setUp() {
        autoCloseable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void shouldFindUserByIdAndReturnFoundUser() {
        //given
        Long id = 1L;
        //when
        when(adapter.findUserById(id)).thenReturn(new User("teste", "123"));
        var response = findUserController.findUserById(id);
        //then
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}