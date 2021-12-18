package com.example.appjambackend.domain.feed.presentation;

import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.requset.PostFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.response.PostFeedResponse;
import com.example.appjambackend.domain.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostFeedResponse feedResponse(@RequestBody @Valid PostFeedRequest request) {
        return feedService.postFeed(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyCarrotFeed(@RequestBody @Valid ModifyFeedRequest request) {
        feedService.modifyFeed(request);
    }

    @PostMapping("/{feed_id}/photo")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadPhoto(@RequestPart List<MultipartFile> files, @PathVariable("feed_id") Long feedId) {
        feedService.uploadPhoto(files, feedId);
    }
}
