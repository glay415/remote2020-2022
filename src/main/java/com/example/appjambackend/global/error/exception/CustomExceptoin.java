package com.example.appjambackend.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExceptoin extends RuntimeException{
    ErrorCode errorCode;
}
