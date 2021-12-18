package com.example.appjambackend.domain.image.exception;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class ImageNotFoundException extends CustomExceptoin {

    public static CustomExceptoin EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
