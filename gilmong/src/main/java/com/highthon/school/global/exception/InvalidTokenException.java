package com.highthon.school.global.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class InvalidTokenException extends BasicException {
	public InvalidTokenException() {
		super(ExceptionMessage.INVALID_TOKEN);
	}
}
