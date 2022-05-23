package com.example.fibonacci.fibonacci.controller;

import com.example.fibonacci.fibonacci.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FibonacciController.class)
class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService fibonacciService;

    @Test
    void getFibonacciTest() throws Exception {
        when(fibonacciService.getFibonacciNumber(6)).thenReturn(8L);
        mockMvc.perform(get("/fibonacci/6")).andExpect(status().isOk())
                .andExpect(jsonPath("$", is(8)));
    }

    @Test
    void getMostAccessedNumberTest() throws Exception {
        when(fibonacciService.getMostAccessedNumber(6)).thenReturn(8);
        mockMvc.perform(get("/fibonacci/statistic/6")).andExpect(status().isOk())
                .andExpect(jsonPath("$", is(8)));
    }
}