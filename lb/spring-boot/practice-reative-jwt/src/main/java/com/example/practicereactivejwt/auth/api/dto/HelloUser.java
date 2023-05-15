package com.example.practicereactivejwt.auth.api.dto;

import lombok.Getter;

@Getter
public class HelloUser {

    private final int userId;
    private final String message;

    public HelloUser(int userId) {
        this.userId = userId;
        this.message = "Hello World!" + userId;
    }
}
