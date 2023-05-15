package com.highthon.school.global.error;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private final int status;
    private final String message;

    ExceptionResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
}