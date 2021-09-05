package com.example.instagramclone.service;

import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public User join(User user) {
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
