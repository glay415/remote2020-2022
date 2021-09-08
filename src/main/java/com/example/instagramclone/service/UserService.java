package com.example.instagramclone.service;

import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.domain.user.UserRepository;
import com.example.instagramclone.handler.ex.CustomException;
import com.example.instagramclone.handler.ex.CustomValidationApiException;
import com.example.instagramclone.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User userProfile(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> {
            throw new CustomException("해당 프로필 페이지는 없는 페이지입니다.");
        });
        user.getImages().get(0);
        return user;
    }

    @Transactional
    public User updateUser(int id, User user) {

        User userEntity = userRepository.findById(id).orElseThrow(()->{ return new CustomValidationApiException("찾을 수 없는 ID 입니다");});

        userEntity.setName(user.getName());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
        return userEntity;
    }
}
