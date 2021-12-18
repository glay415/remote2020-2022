package com.example.appjambackend.domain.user.service;

import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.domain.user.presentation.dto.request.SignInRequest;
import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjambackend.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(SignInRequest signInRequest) {
        return userRepository.findByUserid(signInRequest.getUserid())
                .filter(user -> passwordEncoder.matches(signInRequest.getPassword(), user.getPassword()))
                .map(User::getUserid)
                .map(jwtProvider::generateToken)
                .orElseThrow();
    }
}
