package com.example.fibonacci.fibonacci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fibonacci.fibonacci.model.FibonacciValue;

@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciValue, Integer > {

}
