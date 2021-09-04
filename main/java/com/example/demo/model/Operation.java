package com.example.demo.model;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sum")
    private long sum;

    @Column(name = "write_off")
    private String write_off;

    @Column(name = "write_on")
    private String write_on;

    @Column(name = "reason")
    private String reason;

}
