package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.repository.FeedRepository;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.feed.presentation.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.requset.PostFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{

    private final FeedRepository feedRepository;
    private final FeedFacade feedFacade;

    @Override
    public void postFeed(PostFeedRequest request) {

        Feed feed = feedRepository.save(
                        Feed.builder()
                                .title(request.getTitle())
                                .description(request.getDescription())
                                .build()
        );
    }

    @Override
    public void modifyFeed(ModifyFeedRequest request) {

        Feed feed = feedFacade.getFeedId(request.getFeedId());

        feed
                .changeTitle(request.getTitle())
                .changeDescription(request.getTitle());

    }

    @Override
    public void removeFeed(Long id) {

    }
}
