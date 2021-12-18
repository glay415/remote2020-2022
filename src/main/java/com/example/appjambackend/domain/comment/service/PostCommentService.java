package com.example.appjambackend.domain.comment.service;

import com.example.appjambackend.domain.comment.entity.Comment;
import com.example.appjambackend.domain.comment.entity.CommentRepository;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostCommentService {

    private final CommentRepository commentRepository;
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    public void execute(Long feedId, String content) {
        commentRepository.save(
                Comment.builder()
                        .content(content)
                        .nickname(userFacade.getCurrentStudent().getNickname())
                        .feed(feedFacade.getFeedId(feedId))
                        .build()
        );
    }
}
