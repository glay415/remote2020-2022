package com.example.securitypractice.exception;

import lombok.Getter;

@Getter
public class BusinessExcpetion extends RuntimeException{

    private final ErrorCode errorCode;

    public BusinessExcpetion(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }
}
