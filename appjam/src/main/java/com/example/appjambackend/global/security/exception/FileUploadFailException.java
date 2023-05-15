package com.example.appjambackend.global.security.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class FileUploadFailException extends CustomExceptoin {

    public static CustomExceptoin EXCEPTION =
            new FileUploadFailException();

    public FileUploadFailException() {
        super(ErrorCode.FILE_UPLOAD_FAIL);
    }
}
