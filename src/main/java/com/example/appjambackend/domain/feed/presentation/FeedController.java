package com.example.appjambackend.domain.feed.presentation;

import com.example.appjambackend.domain.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/{feed_id}/photo")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadPhoto(@RequestPart List<MultipartFile> files, @PathVariable("feed_id") Long feedId) {
        feedService.uploadPhoto(files, feedId);
    }
}
