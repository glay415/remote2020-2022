package com.example.appjambackend.domain.comment.service;

import com.example.appjambackend.domain.comment.entity.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RemoveCommentService {

    private final CommentRepository commentRepository;
    public void execute(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
