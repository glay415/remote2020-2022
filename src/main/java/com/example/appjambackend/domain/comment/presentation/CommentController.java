package com.example.appjambackend.domain.comment.presentation;

import com.example.appjambackend.domain.comment.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final PostCommentService postCommentService;

    public void postComment(@RequestParam("feed-id") Long feedId,
                            @RequestParam("content") String content) {
        postCommentService.execute(feedId, content);
    }
}
