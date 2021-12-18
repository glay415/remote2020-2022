package com.example.appjambackend.domain.user.facade;

import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.domain.user.exception.UseridAlreadyExistException;
import com.example.appjambackend.global.security.details.CustomUserDetails;
import com.example.appjambackend.global.util.user.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    public void existsUseridFilter(String userid) {
        if (userRepository.findByUserid(userid).isPresent())
            throw UseridAlreadyExistException.EXCEPTION;
    }

    public User getCurrentStudent() {
        Object principal = userUtil.getPrincipal();

        return ((CustomUserDetails) principal).getUser();
    }
}
