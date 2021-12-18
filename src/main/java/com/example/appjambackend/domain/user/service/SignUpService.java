package com.example.appjambackend.domain.user.service;

import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.domain.user.facade.UserFacade;
import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    public void execute(SignUpRequest signUpRequest) {

        userFacade.existsUseridFilter(signUpRequest.getUserid());

        signUpRequest.encodePassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(new User(signUpRequest));

    }
}
