package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.presentation.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.requset.PostFeedRequest;

public interface FeedService {

    void postFeed(PostFeedRequest request);

    void modifyFeed(ModifyFeedRequest request);

    void removeFeed(Long id);
    
}
