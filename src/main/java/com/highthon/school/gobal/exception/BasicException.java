package com.highthon.school.gobal.exception;

import lombok.Getter;

@Getter
public class BasicException extends RuntimeException{
    private final ExceptionMessage exceptionMessage;

    public BasicException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());

        this.exceptionMessage = exceptionMessage;
    }
}