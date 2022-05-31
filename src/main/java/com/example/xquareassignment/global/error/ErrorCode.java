package com.example.xquareassignment.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	USER_ALREADY_EXIST(409, "User Already Exist");

	private final int status;
	private final String message;
}
