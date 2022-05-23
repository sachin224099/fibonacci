package com.example.fibonacci.fibonacci.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FibonacciRepositoryTest {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(fibonacciRepository);
    }
}
