package com.example.instagramclone.web;

import com.example.instagramclone.web.dto.auth.JoinDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/join")
    public String joinForm() {
        return "auth/Join";
    }

    @PostMapping("/auth/join")
    public String join(JoinDto joinDto){
        return "auth/Login";
    }

    @GetMapping("/auth/login")
    public String loginForm() {
        return "auth/Login";
    }


}
