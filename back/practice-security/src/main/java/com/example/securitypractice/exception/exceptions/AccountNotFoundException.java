package com.example.securitypractice.exception.exceptions;

import com.example.securitypractice.exception.BusinessExcpetion;
import com.example.securitypractice.exception.ErrorCode;

public class AccountNotFoundException extends BusinessExcpetion {
    public AccountNotFoundException() {
        super(ErrorCode.ACCOUNT_NOT_FOUND);
    }
}
