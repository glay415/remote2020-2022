package com.example.project.web;

import com.example.project.web.dto.JoinDto;
import com.example.project.domain.model.User;
import com.example.project.domain.repository.UserRepository;
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
