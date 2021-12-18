package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.FeedRepository;
import com.example.appjambackend.domain.feed.exceptoin.FeedNotFoundException;
import com.example.appjambackend.domain.image.entity.ImageRepository;
import com.example.appjambackend.domain.image.facade.ImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveFeedService {

    private final FeedRepository feedRepository;
    private final ImageFacade imageFacade;

    public void execute(Long id, Feed feed) {

        feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        imageFacade.removeImages(feed);
        feedRepository.deleteById(id);

    }

}
