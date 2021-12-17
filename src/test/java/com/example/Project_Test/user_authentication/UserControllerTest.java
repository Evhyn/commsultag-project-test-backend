package com.example.Project_Test.user_authentication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validateLogin() throws Exception {
        mockMvc.perform(get("/api/v1/user/validateLogin").header(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString("admin:admin".getBytes())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"response\":\"User Successfully Authenticated\"}")));

        mockMvc.perform(get("/api/v1/user/validateLogin").header(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString("User1:User1".getBytes())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"response\":\"User Successfully Authenticated\"}")));

        mockMvc.perform(get("/api/v1/user/validateLogin").header(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString("test:test".getBytes())))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}