package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.FeedRepository;
import com.example.appjambackend.domain.feed.presentation.dto.requset.PostFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.response.PostFeedResponse;
import com.example.appjambackend.domain.image.facade.ImageFacade;
import com.example.appjambackend.global.util.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostFeedService {

    private final FeedRepository feedRepository;
    private final ImageFacade imageFacade;

    @Transactional
    public void execute(List<MultipartFile> images, PostFeedRequest request) {

        Feed feed = feedRepository.save(
                Feed.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .build()
        );
        imageFacade.imageUpload(images, feed);
    }

}
