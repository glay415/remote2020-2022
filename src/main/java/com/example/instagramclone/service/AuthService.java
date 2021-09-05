package com.example.instagramclone.service;

import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.domain.user.UserRepository;
import com.example.instagramclone.web.dto.auth.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User join(JoinDto joinDto) {
        String encPassword = bCryptPasswordEncoder.encode(joinDto.getPassword());
        User user = User.builder()
                .username(joinDto.getUsername())
                .password(encPassword)
                .email(joinDto.getEmail())
                .name(joinDto.getName())
                .role("ROLE_USER")
                .build();
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
