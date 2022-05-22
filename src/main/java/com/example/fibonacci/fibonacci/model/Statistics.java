package com.example.fibonacci.fibonacci.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table
@Builder
public class Statistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx;
	private int count;
	
	public Statistics(){}
	
	public Statistics(int idx, int count){
		this.idx = idx;
		this.count = count;
	}
	
	@Id
	@Column(name="idx")
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	@Column(name="count")
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
