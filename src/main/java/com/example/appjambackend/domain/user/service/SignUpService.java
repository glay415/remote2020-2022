package com.example.appjambackend.domain.user.service;

import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;

    public void execute(SignUpRequest signUpRequest) {
        userRepository.save(
            new User(signUpRequest)
        );
    }
}
