package com.highthon.school.global.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class UserNotFoundException extends BasicException {
    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
    }
}
