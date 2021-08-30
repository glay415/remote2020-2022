package com.example.securitypractice.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class JoinForm {
    private String email;
    private String username;
    private String password;
    private String role;
}
