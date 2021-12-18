package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.FeedMedium;
import com.example.appjambackend.domain.feed.entity.FeedMediumRepository;
import com.example.appjambackend.domain.feed.entity.FeedRepository;
import com.example.appjambackend.domain.feed.exceptoin.FeedNotFoundException;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.requset.PostFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.response.PostFeedResponse;
import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.global.security.exception.FileEmptyException;
import com.example.appjambackend.global.security.exception.TooManyFilesException;
import com.example.appjambackend.global.util.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{

    private static final int MAX_FILE_COUNT = 20;

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedMediumRepository feedMediumRepository;
    private final S3Service s3Service;
    private final FeedFacade feedFacade;

    @Override
    public PostFeedResponse postFeed(PostFeedRequest request) {

        Feed feed = feedRepository.save(
                        Feed.builder()
                                .title(request.getTitle())
                                .description(request.getDescription())
                                .build()
        );
        return null;
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

        feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        feedRepository.deleteById(id);

    }

    @Override
    public void uploadPhoto(List<MultipartFile> files, Long feedId) {

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        if(files == null)
            throw new FileEmptyException();

        if(files.size() + feedMediumRepository.countByFeed(feedId) > MAX_FILE_COUNT)
            throw new TooManyFilesException();


        files.forEach(file ->
                feedMediumRepository.save(FeedMedium.builder()
                        .feed(feed)
                        .fileName(s3Service.upload(file))
                        .build())
        );

    }
}
