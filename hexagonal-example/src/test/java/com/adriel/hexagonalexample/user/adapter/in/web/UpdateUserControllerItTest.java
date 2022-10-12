package com.adriel.hexagonalexample.user.adapter.in.web;

import com.adriel.hexagonalexample.user.application.port.in.RegisterUserCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UpdateUserControllerItTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldUpdateUserAndReturnUser() throws Exception {
        //given
        long id = 5L;
        var userCommand = new RegisterUserCommand("update it test", "IU123");
        var resquestBody = mapper.writeValueAsString(userCommand);
        //when
        var resultActions = mockMvc.perform(put("/api/users/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        //then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.username").value(userCommand.getUsername()))
                .andExpect(jsonPath("$.password").value(userCommand.getPassword()))
                .andDo(print());
    }

    @Test
    void shouldTryToUpdateUserAndGetNotFound() throws Exception {
        //given
        long id = 99L;
        var resquestBody = mapper.writeValueAsString(new RegisterUserCommand("update it test", "IU123"));
        //when
        var resultActions = mockMvc.perform(put("/api/users/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(resquestBody));
        //then
        resultActions.andExpect(status().isNotFound())
                .andExpect(content().string(""))
                .andDo(print());
    }
}