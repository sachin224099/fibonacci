package com.example.fibonacci.fibonacci.service.impl;

import com.example.fibonacci.fibonacci.entity.Fibonacci;
import com.example.fibonacci.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.fibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    @Override
    @Transactional
    public Fibonacci generateAndGetFibonacci(Long n) {
        long f = fibonacci(n);

        Fibonacci fibonacci = Fibonacci.builder().number(f).build();

        return fibonacci;
    }

    private long fibonacci(long N) {
        long num1 = 1, num2 = 2;
        long counter = 0;

        while (counter < N-1) {
            long num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
        return num1;
    }
}
