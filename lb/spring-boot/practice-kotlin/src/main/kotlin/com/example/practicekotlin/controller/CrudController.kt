package com.example.practicekotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CrudController {

    @GetMapping("/hello")
    fun hello() = "hello!"


}