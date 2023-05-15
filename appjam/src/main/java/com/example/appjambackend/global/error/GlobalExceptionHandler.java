package com.example.appjambackend.global.error;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomExceptoin.class)
    public ResponseEntity<ErrorResponse> handlingCustomException(CustomExceptoin e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                new ErrorResponse(errorCode.getMessage()), HttpStatus.valueOf(errorCode.getStatusCode())
        );
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindException(BindException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap , HttpStatus.BAD_REQUEST);
    }
}
