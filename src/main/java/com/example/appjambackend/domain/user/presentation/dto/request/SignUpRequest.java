package com.example.appjambackend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    private String userid;

    private String password;

    private String nickname;

    public void encodePassword(String password) {
        this.password = password;
    }
}
