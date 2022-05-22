package com.example.fibonacci.fibonacci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fibonacci.fibonacci.service.FibonacciService;

/**
 * A controller to handled request flow for fibonacci operations.
 * @author vishal
 *
 */
@RestController
@RequestMapping(value = "/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    /**
     * Get fibonacci number for given index position.
     * @param index
     * @return
     */
    @GetMapping(path="/{idx}")
    public ResponseEntity<Long> getFibonacci(@PathVariable(value="idx") Integer index){
        return ResponseEntity.ok(fibonacciService.getFibonacciNumber(index));
    }
    
    /**
     * Get most accessed number by given position. 
     * @param position
     * @return
     */
    @GetMapping(path="/statistic/{position}")
    public ResponseEntity<Integer> getMostAccessedNumber(@PathVariable(value="position") Integer position){
        return ResponseEntity.ok(fibonacciService.getMostAccessedNumber(position));
    }
}
