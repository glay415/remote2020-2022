package com.example.appjambackend.domain.comment.presentation;

import com.example.appjambackend.domain.comment.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final PostCommentService postCommentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(@RequestParam("feed-id") Long feedId,
                            @RequestParam("content") String content) {
        postCommentService.execute(feedId, content);
    }
}
