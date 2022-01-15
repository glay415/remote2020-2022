package com.highthon.school.gobal.exception;

public class UserNotFoundException extends BasicException{
    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
    }
}
