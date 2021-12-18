package com.example.appjambackend.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    FEED_NOT_FOUND_EXCEPTION(404, "feed Not Found"),
    ;

    private final int statusCode;
    private final String message;
}
