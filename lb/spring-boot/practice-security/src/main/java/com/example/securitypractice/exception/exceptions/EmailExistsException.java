package com.example.securitypractice.exception.exceptions;

import com.example.securitypractice.exception.BusinessExcpetion;
import com.example.securitypractice.exception.ErrorCode;

public class EmailExistsException extends BusinessExcpetion {
    public EmailExistsException(){
        super(ErrorCode.EMAIL_ALREADY_EXISTS);
    }
}
