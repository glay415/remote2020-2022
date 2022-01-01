package com.example.practicekotlin.entity

import javax.persistence.*

@Entity
class TestEntity (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int = 0,

        @Column(nullable = false)
        var title: String,

        @Column(nullable = false)
        var content: String
){

}