package com.example.securitypractice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_TOKEN(401, "Invalid Token"),
    INVALID_PASSWORD(401, "Invalid Password"),

    USER_ALREADY_EXISTS(409, "User Already Exists"),
    EMAIL_ALREADY_EXISTS(409, "Email Already Exists"),

    ACCOUNT_NOT_FOUND(404, "Account Not Found");

    private final int status;
    private final String message;
}
