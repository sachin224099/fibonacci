package com.example.fibonacci.fibonacci.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Builder;

@Entity
@Table
@Builder
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="fibonacci")
public class FibonacciValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx;
	private int sum;
	
	public FibonacciValue(){
	}
	
	FibonacciValue(int idx, int sum){
		this.idx=idx;
		this.sum=sum;
	}
	
	@Id
	@Column(name="idx")
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Column(name="sum")
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
