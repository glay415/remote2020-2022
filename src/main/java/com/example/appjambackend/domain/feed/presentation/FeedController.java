package com.example.appjambackend.domain.feed.presentation;

import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.feed.presentation.dto.requset.PostFeedRequest;
import com.example.appjambackend.domain.feed.service.ModifyFeedService;
import com.example.appjambackend.domain.feed.service.PostFeedService;
import com.example.appjambackend.domain.feed.service.RemoveFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final ModifyFeedService modifyFeedService;
    private final PostFeedService postFeedService;
    private final RemoveFeedService removeFeedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void feedResponse(@RequestBody @Valid PostFeedRequest request) {
        postFeedService.execute(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyCarrotFeed(@RequestBody @Valid ModifyFeedRequest request) {
        modifyFeedService.execute(request);
    }

    @DeleteMapping("/{feed_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFeed(@PathVariable(name = "feed_id") Long feedId) {
        removeFeedService.execute(feedId);
    }

}
