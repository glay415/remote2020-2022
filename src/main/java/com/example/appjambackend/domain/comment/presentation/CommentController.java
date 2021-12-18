package com.example.appjambackend.domain.comment.presentation;

import com.example.appjambackend.domain.comment.service.PostCommentService;
import com.example.appjambackend.domain.comment.service.RemoveCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final PostCommentService postCommentService;
    private final RemoveCommentService removeCommentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(@RequestParam("feed-id") Long feedId,
                            @RequestParam("content") String content) {
        postCommentService.execute(feedId, content);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postComment(@RequestParam("comment-id") Long commentId) {
        removeCommentService.execute(commentId);
    }
}
