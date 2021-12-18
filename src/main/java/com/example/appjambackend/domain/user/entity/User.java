package com.example.appjambackend.domain.user.entity;

import com.example.appjambackend.domain.user.presentation.dto.request.SignUpRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid", unique = true)
    private String userid;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    public User(SignUpRequest signUpRequest) {
        this.nickname = signUpRequest.getNickname();
        this.userid = signUpRequest.getUserid();
        this.password = signUpRequest.getPassword();
    }

}
