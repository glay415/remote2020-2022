package com.example.appjambackend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MyPageResponse {

    private String nickname;
    private String userid;
    private List<String> myFeed;
    private List<String> myMark;

}
