package com.example.faq.entity;

import javax.persistence.*;

@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private Subject subject;



}
