package com.example.instagramclone.web;

import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.handler.ex.CustomValidationException;
import com.example.instagramclone.service.AuthService;
import com.example.instagramclone.web.dto.auth.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/join")
    public String joinForm() {
        return "auth/Join";
    }

    @PostMapping("/auth/join")
    public String join(@Valid JoinDto joinDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패함", errorMap);
        } else {
            User userEntity = authService.join(joinDto);
            System.out.println(userEntity);
            return "auth/Login";
        }
    }

    @GetMapping("/auth/login")
    public String loginForm() {
        return "auth/Login";
    }


}
