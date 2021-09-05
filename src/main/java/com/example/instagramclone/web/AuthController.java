package com.example.instagramclone.web;

import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.service.AuthService;
import com.example.instagramclone.web.dto.auth.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/join")
    public String joinForm() {
        return "auth/Join";
    }

    @PostMapping("/auth/join")
    public String join(JoinDto joinDto){
        User userEntity = authService.join(joinDto);
        System.out.println(userEntity);
        return "auth/Login";
    }

    @GetMapping("/auth/login")
    public String loginForm() {
        return "auth/Login";
    }


}
