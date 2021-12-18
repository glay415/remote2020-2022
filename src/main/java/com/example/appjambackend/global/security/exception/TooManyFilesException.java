package com.example.appjambackend.global.security.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class TooManyFilesException extends CustomExceptoin {

    public CustomExceptoin EXCEPTION =
            new TooManyFilesException();

    public TooManyFilesException() {
        super(ErrorCode.TOO_MANY_FILES);
    }
}
