package com.adriel.hexagonalexample.user.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FindUserControllerItTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void findUserByIdShouldReturnUser() throws Exception {
        //given
        long id = 5L;
        //when
        var resultActions = mockMvc.perform(get("/api/users/"+id)
                .accept(MediaType.APPLICATION_JSON));
        //then
        var mvcResult = resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.username").isNotEmpty())
                .andExpect(jsonPath("$.password").isNotEmpty())
                .andDo(print());
    }

    @Test
    void findUserByIdShouldReturnNotFound() throws Exception {
        //given
        long id = 72L;
        //when
        var resultActions = mockMvc.perform(get("/api/users/{id}", id));
        //then
        resultActions.andExpect(status().isNotFound())
                .andExpect(content().string(""))
                .andDo(print());
    }
}