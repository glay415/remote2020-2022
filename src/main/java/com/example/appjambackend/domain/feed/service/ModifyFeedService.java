package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyFeedService {

    private final FeedFacade feedFacade;

    public void execute(ModifyFeedRequest request) {

        Feed feed = feedFacade.getFeedId(request.getFeedId());

        feed
                .changeTitle(request.getTitle())
                .changeDescription(request.getTitle());

    }

}
