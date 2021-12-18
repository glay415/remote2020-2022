package com.example.appjambackend.domain.user.service;

import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjambackend.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final JwtProvider jwtProvider;

    public TokenResponse execute(String refresh) {
        return jwtProvider.reissue(refresh);
    }
}
