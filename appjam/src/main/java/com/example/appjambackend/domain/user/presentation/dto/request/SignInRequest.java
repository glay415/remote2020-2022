package com.example.appjambackend.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignInRequest {

    @NotBlank(message = "userid는 Null, 공백을 허용하지 않습니다.")
    private String userid;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    private String password;

}
