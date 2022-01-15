package com.highthon.school.global.error;

public class UserNotFoundException extends BasicException{
    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
    }
}
