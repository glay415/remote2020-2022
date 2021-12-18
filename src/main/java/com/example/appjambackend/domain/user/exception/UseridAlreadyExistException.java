package com.example.appjambackend.domain.user.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class UseridAlreadyExistException extends CustomExceptoin {
    public static CustomExceptoin EXCEPTION =
            new UseridAlreadyExistException();

    private UseridAlreadyExistException() {
        super(ErrorCode.USERID_ALREADY_EXISTS);
    }
}
