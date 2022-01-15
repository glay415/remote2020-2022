package com.highthon.school.domain.user.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class CredentialsNotFoundException extends BasicException {
	public CredentialsNotFoundException() {
		super(ExceptionMessage.CREDENTIALS_NOT_FOUND);
	}
}
