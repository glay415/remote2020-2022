package com.example.appjambackend.domain.user.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomExceptoin {

    public static CustomExceptoin EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
