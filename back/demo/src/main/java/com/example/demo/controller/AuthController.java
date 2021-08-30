package com.example.demo.controller;

import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import com.example.demo.auth.JwtTokenProvider;
import com.example.demo.payload.JoinRequestDto;
import com.example.demo.payload.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @PostMapping("join")
    public String join(@RequestBody JoinRequestDto joinRequestDto) {
        userRepository.save(joinRequestDto.toEntity(passwordEncoder));
        return "JoinSuccess";
    }

    @PostMapping("login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        return loginRequestDto.createToken(userRepository, passwordEncoder, tokenProvider);
    }
}
