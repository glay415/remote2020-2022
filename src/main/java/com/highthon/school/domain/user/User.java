package com.highthon.school.domain.user;

import com.highthon.school.domain.interest.Interest;

import com.highthon.school.domain.user.dto.SignUpRequestDto;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import javax.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    private String id;
    private String password;
    private String nickname;

    @OneToMany
    private List<Interest> interest;

    public User(SignUpRequestDto signUpRequest) {
        this.id = signUpRequest.getId();
        this.password = signUpRequest.getPassword();
        this.nickname = signUpRequest.getNickname();
    }
}
