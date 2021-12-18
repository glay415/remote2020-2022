package com.example.appjambackend.domain.user.presentation;

import com.example.appjambackend.domain.user.presentation.dto.request.SignInRequest;
import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import com.example.appjambackend.domain.user.presentation.dto.response.TokenResponse;
import com.example.appjambackend.domain.user.service.SignInService;
import com.example.appjambackend.domain.user.service.SignUpService;
import com.example.appjambackend.domain.user.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final TokenRefreshService tokenRefreshService;

    @PostMapping("/auth")
    public void signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }

    @PutMapping("/auth")
    public TokenResponse singIn(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.execute(signInRequest);
    }

    @PatchMapping("/auth")
    public TokenResponse reissue(@RequestHeader("X-Refresh-Token") String refresh) {
        return tokenRefreshService.execute(refresh);
    }
}