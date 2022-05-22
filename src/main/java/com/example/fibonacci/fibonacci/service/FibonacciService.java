package com.example.fibonacci.fibonacci.service;

/**
 * Service to list all operation related to fibonacci series.
 * @author vishal
 *
 */
public interface FibonacciService {
    public long getFibonacciNumber(int n);
    public int getMostAccessedNumber(int position);
}
