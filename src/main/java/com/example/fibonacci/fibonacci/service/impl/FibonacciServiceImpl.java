package com.example.fibonacci.fibonacci.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.example.fibonacci.fibonacci.model.FibonacciValue;
import com.example.fibonacci.fibonacci.model.Statistics;
import com.example.fibonacci.fibonacci.repository.FibonacciRepository;
import com.example.fibonacci.fibonacci.repository.StatisticRepository;
import com.example.fibonacci.fibonacci.service.FibonacciService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FibonacciServiceImpl implements FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;
    
    @Autowired
    private StatisticRepository statisticRepository;

    /* 
     * Calculate and return fibonacci number for given position.
     * (non-Javadoc)
     * @see com.example.fibonacci.fibonacci.service.FibonacciService#getFibonacciNumber(int)
     */
    @Transactional
    @Override
    public long getFibonacciNumber(int n) {
    	log.info(" - Entry");
    	saveStatistic(n);
        long fiboNumber = getFinonacciNumber(n);
        log.info(" - Exit");
        return fiboNumber;
    } 
    
    /*  
     * Get most accessed number by given position.
     * (non-Javadoc)
     * @see com.example.fibonacci.fibonacci.service.FibonacciService#getMostAccessedNumber(int)
     */
    @Override
	public int getMostAccessedNumber(int position) {
    	log.info("- Entry");
    	Long count = statisticRepository.count();
    	if(count<=0 || position>count)
    		return 0;
    	else
    		return statisticRepository.getMostAccessedNumber(position-1);
	}
    
    private int getFinonacciNumber(int number) {
    	log.info("- Entry");
    	int result = 0;
    	if (number == 0) { 
    		return number; 
    	} else if (number == 1) { 
    		return 1;
    	} else {
    		FibonacciValue fiboValue = getById(number);
    		if(null != fiboValue)
    			result = fiboValue.getSum();
    		else {
    			result = getFinonacciNumber(number - 2) + getFinonacciNumber(number - 1); 
    			saveSummary(FibonacciValue.builder().idx(number).sum(result).build());
    		}
    	}
    	return result;
    }
    
    private FibonacciValue getById(int number){
    	log.info("- Entry");
    	Optional<FibonacciValue> fiboValue = fibonacciRepository.findById(number);
    	if(fiboValue.isPresent())
    		return fiboValue.get();
    	return null;
    }
    
    private FibonacciValue saveSummary(FibonacciValue fiboValue){
    	log.info("- Entry");
    	fibonacciRepository.save(fiboValue);
    	return fiboValue;
    }
    
    private void saveStatistic(int number){
    	log.info("- Entry");
    	Optional<Statistics> statistics = statisticRepository.findById(number);
    	if(statistics.isPresent()){
    		Statistics stat = statistics.get();
    		stat.setCount(stat.getCount()+1);
    		statisticRepository.save(stat);
    	} else {
    		statisticRepository.save(Statistics.builder().idx(number).count(1).build());
    	}
    	log.info("- Exit");
    }
	
}
