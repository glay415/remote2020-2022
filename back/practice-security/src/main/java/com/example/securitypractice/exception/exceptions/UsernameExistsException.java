package com.example.securitypractice.exception.exceptions;

import com.example.securitypractice.exception.BusinessExcpetion;
import com.example.securitypractice.exception.ErrorCode;

public class UsernameExistsException extends BusinessExcpetion {
    public UsernameExistsException(){
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
