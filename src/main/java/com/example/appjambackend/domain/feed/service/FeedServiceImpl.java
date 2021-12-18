package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.repository.FeedRepository;
import com.example.appjambackend.domain.feed.presentation.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.requset.PostFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{

    private final FeedRepository feedRepository;

    @Override
    public void postFeed(PostFeedRequest request) {

    }

    @Override
    public void modifyFeed(ModifyFeedRequest request) {

    }

    @Override
    public void removeFeed(Long id) {

    }
}
