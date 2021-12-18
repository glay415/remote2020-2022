package com.example.appjambackend.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    FEED_NOT_FOUND_EXCEPTION(404, "feed Not Found"),

    FILE_UPLOAD_FAIL(400,"File Upload Fail"),
    FILE_EMPTY(400, "File is Empty"),

    TOO_MANY_FILES(413,"TOO Many Files"),
    USERID_ALREADY_EXISTS(409, "Userid Already Exists"),
    FEED_NOT_FOUND_EXCEPTION(404, "feed Not Found")
    ;

    private final int statusCode;
    private final String message;
}
