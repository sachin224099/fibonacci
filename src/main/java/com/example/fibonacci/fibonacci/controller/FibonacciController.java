package com.example.fibonacci.fibonacci.controller;

import com.example.fibonacci.fibonacci.dto.NumberDto;
import com.example.fibonacci.fibonacci.entity.Fibonacci;
import com.example.fibonacci.fibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @PostMapping
    public ResponseEntity<Fibonacci> getFibonacci(@RequestBody NumberDto dto){
        return ResponseEntity.ok(fibonacciService.generateAndGetFibonacci(dto.getNumber()));
    }
}
