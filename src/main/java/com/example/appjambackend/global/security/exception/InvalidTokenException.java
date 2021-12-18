package com.example.appjambackend.global.security.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomExceptoin {

    public static CustomExceptoin EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
