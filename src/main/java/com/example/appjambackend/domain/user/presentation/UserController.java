package com.example.appjambackend.domain.user.presentation;

import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import com.example.appjambackend.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;

    @PostMapping("/auth")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }
}