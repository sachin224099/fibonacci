package com.example.fibonacci.fibonacci.service.impl;

import com.example.fibonacci.fibonacci.entity.Fibonacci;
import com.example.fibonacci.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.fibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    @Override
    public Fibonacci generateAndGetFibonacci(Long n) {


        return null;
    }
}
