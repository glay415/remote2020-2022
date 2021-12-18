package com.example.appjambackend.domain.like.service;

import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.like.entity.Like;
import com.example.appjambackend.domain.like.entity.LikeRepository;
import com.example.appjambackend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostLikeService{

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final LikeRepository likeRepository;

    public void execute(Long feedId) {
        likeRepository.save(
                new Like(feedFacade.getFeedId(feedId), userFacade.getCurrentUser())
        );
    }
}
