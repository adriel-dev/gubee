package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.adriel.hexagonalexample.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterUserControllerItTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldRegisterUserAndReturnUser() throws Exception {
        //given
        Random random = new Random();
        RegisterUserCommand userCommand = new RegisterUserCommand("register test "+random.nextInt(), "7654321");
        var requestBody = mapper.writeValueAsString(userCommand);
        //when
        var resultActions = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        );
        //then
        var responseString = resultActions.andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.username").value(userCommand.getUsername()))
                .andExpect(jsonPath("$.password").value(userCommand.getPassword()))
                .andDo(print());
    }

    @Test
    void registerUserShouldGiveAnErrorOnDuplicatedUsername() throws Exception {
        //given
        RegisterUserCommand userCommand = new RegisterUserCommand("register test", "7654321");
        var requestBody = mapper.writeValueAsString(userCommand);
        //when
        var resultActions = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        );
        //then
        resultActions.andExpect(status().isConflict())
                .andExpect(content().string(""))
                .andDo(print());
    }

}