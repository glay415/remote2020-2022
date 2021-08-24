package com.example.securitypractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessExcpetion.class)
    public ResponseEntity<ExceptionResponse> handleException(BusinessExcpetion e) {
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ExceptionResponse(errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

}
