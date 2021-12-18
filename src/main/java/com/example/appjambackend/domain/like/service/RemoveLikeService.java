package com.example.appjambackend.domain.like.service;

import com.example.appjambackend.domain.like.entity.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RemoveLikeService {

    private final LikeRepository likeRepository;

    public void execute(Long feedId) {
        likeRepository.deleteById(feedId);
    }
}
