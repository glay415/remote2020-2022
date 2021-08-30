package com.example.demo.payload;

import com.example.demo.User.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class JoinRequestDto {
    private String username;
    private String password;
    private String email;

    @Builder
    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(this.username)
                .password(passwordEncoder.encode(this.password))
                .email(this.email)
                .roles("ROLE_USER")
                .build();
    }
}
