package com.example.xquareassignment.application.exception;

import com.example.xquareassignment.global.error.CustomException;
import com.example.xquareassignment.global.error.ErrorCode;

public class UserAlreadyExistException extends CustomException {

	public static CustomException EXCEPTION = new UserAlreadyExistException();

	private UserAlreadyExistException() {
		super(ErrorCode.USER_ALREADY_EXIST);
	}
}
