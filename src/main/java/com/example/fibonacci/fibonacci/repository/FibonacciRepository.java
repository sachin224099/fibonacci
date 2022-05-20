package com.example.fibonacci.fibonacci.repository;

import com.example.fibonacci.fibonacci.entity.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends JpaRepository<Long, Fibonacci> {

}
