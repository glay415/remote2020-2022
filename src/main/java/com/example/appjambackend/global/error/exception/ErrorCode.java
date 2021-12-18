package com.example.appjambackend.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    USERID_ALREADY_EXISTS(409, "Userid Already Exists"),
    FEED_NOT_FOUND_EXCEPTION(404, "feed Not Found")
    ;

    private final int statusCode;
    private final String message;
}
