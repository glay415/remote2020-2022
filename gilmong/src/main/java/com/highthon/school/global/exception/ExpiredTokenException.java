package com.highthon.school.global.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class ExpiredTokenException extends BasicException {
	public ExpiredTokenException() {
		super(ExceptionMessage.TOKEN_EXPIRED);
	}
}
