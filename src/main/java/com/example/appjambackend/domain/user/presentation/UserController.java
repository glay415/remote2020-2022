package com.example.appjambackend.domain.user.presentation;

import com.example.appjambackend.domain.user.presentation.dto.request.SignInRequest;
import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjambackend.domain.user.service.SignInService;
import com.example.appjambackend.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/auth")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }

    @PutMapping("/auth")
    public TokenResponse singIn(@RequestBody SignInRequest signInRequest) {
        return signInService.execute(signInRequest);
    }
}