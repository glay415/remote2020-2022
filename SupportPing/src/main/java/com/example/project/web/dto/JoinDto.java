package com.example.project.web.dto;

import com.example.project.domain.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
