package com.example.instagramclone.web.dto.auth;

import lombok.Data;

@Data
public class JoinDto {
    private String username;
    private String password;
    private String email;
    private String name;

}
