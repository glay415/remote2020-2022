package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.requset.PostFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.response.PostFeedResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FeedService {

    PostFeedResponse postFeed(PostFeedRequest request);

    void modifyFeed(ModifyFeedRequest request);

    void removeFeed(Long id);

    void uploadPhoto(List<MultipartFile> files, Long feedId);
}
