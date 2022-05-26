package com.example.fibonacci.fibonacci.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.fibonacci.fibonacci.service.FibonacciService;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciControllerTest {

	@InjectMocks
	FibonacciController controller;
	
    @Mock
    private FibonacciService fibonacciService;

    @Before
    public void init(){
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getFibonacciTest() throws Exception {
        when(fibonacciService.getFibonacciNumber(6)).thenReturn(8L);
        controller.getFibonacci(6);
    }

    @Test
    public void getMostAccessedNumberTest() throws Exception {
        when(fibonacciService.getMostAccessedNumber(6)).thenReturn(8);
        controller.getMostAccessedNumber(6);
    }
}