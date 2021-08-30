package com.example.securitypractice.exception.exceptions;

import com.example.securitypractice.exception.BusinessExcpetion;
import com.example.securitypractice.exception.ErrorCode;

public class InvalidPasswordException extends BusinessExcpetion {
    public InvalidPasswordException(){
        super(ErrorCode.INVALID_PASSWORD);
    }
}
