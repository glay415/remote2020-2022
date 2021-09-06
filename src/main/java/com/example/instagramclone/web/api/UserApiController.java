package com.example.instagramclone.web.api;

import com.example.instagramclone.config.auth.PrincipalDetails;
import com.example.instagramclone.domain.user.User;
import com.example.instagramclone.handler.ex.CustomValidationApiException;
import com.example.instagramclone.handler.ex.CustomValidationException;
import com.example.instagramclone.service.UserService;
import com.example.instagramclone.web.dto.CMRespDto;
import com.example.instagramclone.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(
            @PathVariable int id,
            @Valid UserUpdateDto userUpdateDto,
            BindingResult bindingResult,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
        } else {
            User userEntity = userService.updateUser(id, userUpdateDto.toEntity());
            principalDetails.setUser(userEntity);
            return new CMRespDto<>(1, "회원수정완료", userEntity);
        }
    }
}
