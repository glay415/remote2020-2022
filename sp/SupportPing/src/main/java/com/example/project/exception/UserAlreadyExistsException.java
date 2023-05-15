package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super("USER_ALREADY_EXISTS", HttpStatus.CONFLICT);
    }
}
