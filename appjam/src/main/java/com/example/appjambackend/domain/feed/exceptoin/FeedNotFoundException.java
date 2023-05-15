package com.example.appjambackend.domain.feed.exceptoin;

import com.example.appjambackend.global.error.exception.CustomExceptoin;
import com.example.appjambackend.global.error.exception.ErrorCode;

public class FeedNotFoundException extends CustomExceptoin {

    public static CustomExceptoin EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND_EXCEPTION);
    }
}
