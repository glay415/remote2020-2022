package com.example.appjambackend.domain.feed.facade;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.repository.FeedRepository;
import com.example.appjambackend.domain.feed.exceptoin.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedId(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTOIN);
    }
}
