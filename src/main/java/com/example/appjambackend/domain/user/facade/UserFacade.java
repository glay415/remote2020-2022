package com.example.appjambackend.domain.user.facade;

import com.example.appjambackend.domain.user.entity.UserRepository;
import com.example.appjambackend.domain.user.exception.UseridAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public void existsUseridFilter(String userid) {
        if (userRepository.findByUserid(userid).isPresent())
            throw UseridAlreadyExistException.EXCEPTION;
    }
}
