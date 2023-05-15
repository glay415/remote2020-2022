package com.example.project.exception;

import com.example.project.exception.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleException(BusinessException e) {
        return new ResponseEntity<>(new ExceptionResponse(e.getCode()), e.getStatus());
    }
}
