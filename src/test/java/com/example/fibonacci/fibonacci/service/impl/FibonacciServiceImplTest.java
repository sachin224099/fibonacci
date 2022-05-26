package com.example.fibonacci.fibonacci.service.impl;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.fibonacci.fibonacci.model.FibonacciValue;
import com.example.fibonacci.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.fibonacci.repository.StatisticRepository;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciServiceImplTest {

    @Mock
    FibonacciRepository fibonacciRepository;
    
    @Mock
    StatisticRepository statisticRepository;
    
    @InjectMocks
    FibonacciServiceImpl fibonacciService;
    
    @Before
    public void init(){
    	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_get_fibonacci_value(){
        Assert.assertEquals(0, fibonacciService.getFibonacciNumber(0));
        Assert.assertEquals(1, fibonacciService.getFibonacciNumber(1));
        Assert.assertEquals(13, fibonacciService.getFibonacciNumber(7));

        when(fibonacciRepository.findById(3)).thenReturn(Optional.of(FibonacciValue.builder().idx(3).sum(2).build()));
        Assert.assertEquals(2, fibonacciService.getFibonacciNumber(3));
    }

    @Test
    public void test_most_accessed_number(){
        when(statisticRepository.count()).thenReturn(15L);
        when(statisticRepository.getMostAccessedNumber(12)).thenReturn(4);
        Assert.assertEquals(4, fibonacciService.getMostAccessedNumber(13));
    }

}