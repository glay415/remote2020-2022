package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.presentation.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.requset.PostFeedRequest;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FeedService {

    void postFeed(PostFeedRequest request);

    void modifyFeed(ModifyFeedRequest request);

    void removeFeed(Long id);

    void uploadPhoto(List<MultipartFile> files, Long feedId);
}
