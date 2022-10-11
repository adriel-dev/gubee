package com.adriel.hexagonalexample.user.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeleteUserControllerItTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeleteUserController deleteUserController;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldDeleteUser() throws Exception {
        //given
        long id = 4L;
        //when
        var resultActions = mockMvc.perform(delete("/api/users/{id}", id));
        //then
        resultActions.andExpect(status().isOk()).andDo(print());
    }

}