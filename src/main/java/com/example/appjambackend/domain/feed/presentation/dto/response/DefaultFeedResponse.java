package com.example.appjambackend.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultFeedResponse {

    private final Long feedId;
    private final String title;
    private boolean like;

    public void setLike(boolean like) {
        this.like = like;
    }
}
