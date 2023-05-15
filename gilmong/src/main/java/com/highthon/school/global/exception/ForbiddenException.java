package com.highthon.school.global.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class ForbiddenException extends BasicException {
	public ForbiddenException() {super(ExceptionMessage.FORBIDDEN);}
}
