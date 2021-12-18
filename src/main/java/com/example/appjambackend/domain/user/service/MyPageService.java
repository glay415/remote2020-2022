package com.example.appjambackend.domain.user.service;

import com.example.appjambackend.domain.like.entity.LikeRepository;
import com.example.appjambackend.domain.mark.entity.Mark;
import com.example.appjambackend.domain.mark.entity.MarkRepository;
import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.facade.UserFacade;
import com.example.appjambackend.domain.user.presentation.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserFacade userFacade;
    private final MarkRepository markRepository;
    private final LikeRepository likeRepository;

    public MyPageResponse execute() {

        User user = userFacade.getCurrentUser();


        return MyPageResponse.builder()
                .nickname(user.getNickname())
                .userid(user.getUserid())
                .myFeed(
                        markRepository.findByUser(user)
                                .stream()
                                .map(mark -> mark.getFeed().getImages().get(0).getImageUrl())
                                .collect(Collectors.toList())
                )
                .myMark(
                        likeRepository.findByUser(user)
                                .stream()
                                .map(mark -> mark.getFeed().getImages().get(0).getImageUrl())
                                .collect(Collectors.toList())
                )
                .build();
    }
}
