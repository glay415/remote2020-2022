package com.example.securitypractice.service;

import com.example.securitypractice.config.auth.PrincipalDetails;
import com.example.securitypractice.domain.UserEntity;
import com.example.securitypractice.dto.JoinForm;
import com.example.securitypractice.dto.LoginForm;
import com.example.securitypractice.exception.exceptions.AccountNotFoundException;
import com.example.securitypractice.exception.exceptions.EmailExistsException;
import com.example.securitypractice.exception.exceptions.InvalidPasswordException;
import com.example.securitypractice.exception.exceptions.UsernameExistsException;
import com.example.securitypractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    @Transactional
    public String join(JoinForm joinForm){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserEntity userEntity = UserEntity.builder()
                .email(joinForm.getEmail())
                .username(joinForm.getUsername())
                .password(passwordEncoder.encode(joinForm.getPassword()))
                .role("ROLE_USER")
                .build();
        if(userRepository.existsByUsername(joinForm.getUsername())) throw new UsernameExistsException();
        if(userRepository.existsByEmail(joinForm.getEmail())) throw new EmailExistsException();
        userRepository.save(userEntity);
        return "join success";
    }

    @Transactional
    public UserDetails login(LoginForm loginForm) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = userRepository.findByUsername(loginForm.getUsername());

        if (userEntity != null) {
            if (passwordEncoder.matches(loginForm.getPassword(), userEntity.getPassword())) {
                return new PrincipalDetails(userEntity);
            } else {
                System.out.println("비밀번호가 틀림");
                throw new InvalidPasswordException();
            }
        } else {
            throw new AccountNotFoundException();
        }
    }
}
