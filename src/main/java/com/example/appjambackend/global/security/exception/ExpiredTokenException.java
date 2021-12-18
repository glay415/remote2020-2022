package com.example.appjambackend.global.security.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomExceptoin {
    public static CustomExceptoin EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
