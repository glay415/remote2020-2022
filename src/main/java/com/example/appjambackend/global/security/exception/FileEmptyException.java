package com.example.appjambackend.global.security.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class FileEmptyException extends CustomExceptoin {

    public static  CustomExceptoin EXCEPTONI=
            new FileEmptyException();

    public FileEmptyException() {
        super(ErrorCode.FILE_EMPTY);
    }
}
