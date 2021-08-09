package com.example.project.dto;

import com.example.project.model.User;
import lombok.Data;

@Data
public class JoinDto {
    private String name;
    private String username;
    private String password;

    public User toEntity(){
        return User.builder()
                .name(name)
                .username(username)
                .password(password)
                .roles("ROLE_USER")
                .build();
    }
}
