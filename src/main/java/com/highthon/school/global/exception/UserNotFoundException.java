package com.highthon.school.global.exception;

public class UserNotFoundException extends BasicException{
    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
    }
}
