package com.example.fibonacci.fibonacci.service.impl;

import com.example.fibonacci.fibonacci.model.FibonacciValue;
import com.example.fibonacci.fibonacci.model.Statistics;
import com.example.fibonacci.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.fibonacci.repository.StatisticRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class FibonacciServiceImplTest {

    @Mock
    FibonacciRepository fibonacciRepository;
    @Mock
    StatisticRepository statisticRepository;
    @InjectMocks
    FibonacciServiceImpl fibonacciService;

    @Test
    public void getFibonacciNumberTest(){
        assertEquals(0, fibonacciService.getFibonacciNumber(0));
        assertEquals(1, fibonacciService.getFibonacciNumber(1));
        assertEquals(13, fibonacciService.getFibonacciNumber(7));

        when(fibonacciRepository.findById(6)).thenReturn(Optional.of(FibonacciValue.builder().idx(6).sum(8).build()));
        when(statisticRepository.findById(6)).thenReturn(Optional.of(Statistics.builder().idx(6).count(7).build()));
        assertEquals(8, fibonacciService.getFibonacciNumber(6));
    }

    @Test
    public void getMostAccessedNumberTest(){
        assertEquals(0, fibonacciService.getMostAccessedNumber(12));
        when(statisticRepository.count()).thenReturn(23L);
        when(statisticRepository.getMostAccessedNumber(12)).thenReturn(4);
        assertEquals(4, fibonacciService.getMostAccessedNumber(13));
    }

}