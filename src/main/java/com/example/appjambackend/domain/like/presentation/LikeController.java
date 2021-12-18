package com.example.appjambackend.domain.like.presentation;

import com.example.appjambackend.domain.like.service.PostLikeService;
import com.example.appjambackend.domain.like.service.RemoveLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/like")
public class LikeController {

    private final PostLikeService postLikeService;
    private final RemoveLikeService removeLikeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postLike(@RequestParam("feed-id") Long feedId) {
        postLikeService.execute(feedId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLike(@RequestParam("feed-id") Long feedId) {
        removeLikeService.execute(feedId);
    }
}
