package com.example.securitypractice.controller;

import com.example.securitypractice.dto.JoinForm;
import com.example.securitypractice.dto.LoginForm;
import com.example.securitypractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/member/join")
    public String userJoin(@RequestBody JoinForm joinForm){
        return userService.join(joinForm);
    }

    @PostMapping("/member/login")
    public String userLogin(@RequestBody LoginForm loginForm){
        return userService.login(loginForm);
    }
}
