package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.FeedRepository;
import com.example.appjambackend.domain.feed.exceptoin.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveFeedService {

    private final FeedRepository feedRepository;

    public void execute(Long id) {

        feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        feedRepository.deleteById(id);

    }

}
