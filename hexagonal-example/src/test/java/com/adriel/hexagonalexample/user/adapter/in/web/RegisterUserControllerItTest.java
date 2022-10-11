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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        var response = mapper.readValue(responseString, User.class);
        assertThat(response).isNotNull();
        assertThat(response.getUsername()).isEqualTo(userCommand.getUsername());
        assertThat(response.getPassword()).isEqualTo(userCommand.getPassword());
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
        var responseString = resultActions.andExpect(status().isConflict())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(responseString).isEmpty();
    }

}