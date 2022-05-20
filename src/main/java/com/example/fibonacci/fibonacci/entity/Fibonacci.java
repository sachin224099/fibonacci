package com.example.fibonacci.fibonacci.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "FIBONACCI")
@Data
@Builder
public class Fibonacci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NUMBER",nullable=false)
    private Long number;

    @Column(name="VALUE",nullable=false)
    private Long value;

}
