package com.highthon.school.domain.user.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class UserAlreadyExistException extends BasicException {
	public UserAlreadyExistException() {
		super(ExceptionMessage.USER_ALREADY_EXIST);
	}
}
