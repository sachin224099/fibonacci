package com.example.fibonacci.fibonacci.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StatisticRepositoryTest {
    @Autowired
    private StatisticRepository statisticRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(statisticRepository);
    }
}
