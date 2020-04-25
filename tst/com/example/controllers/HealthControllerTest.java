package com.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
public class HealthControllerTest {

    @Autowired
    private HealthController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testContextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    public void testHealthControllerReturnsHealthy() throws Exception {
        this.mockMvc.perform(get(HealthController.HEALTH_PATH))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(HealthController.HEALTHY_REPLY)));
    }
}