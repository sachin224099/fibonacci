package com.example.fibonacci.fibonacci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fibonacci.fibonacci.model.Statistics;

@Repository
public interface StatisticRepository extends JpaRepository<Statistics, Integer> {
	
	@Query(value="select idx from statistics order by count desc limit ?1, 1",nativeQuery=true)
	public int getMostAccessedNumber(int position);

}
