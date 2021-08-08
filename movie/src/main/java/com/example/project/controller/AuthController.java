package com.example.project.controller;

import com.example.project.dto.JoinDto;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public User join(@RequestBody JoinDto joinDto) {
        joinDto.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
        return userRepository.save(joinDto.toEntity());
    }

}
