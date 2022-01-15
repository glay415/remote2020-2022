package com.highthon.school.domain.user;

import com.highthon.school.domain.interest.Interest;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
public class User {
    @Id
    private String id;
    private String password;
    private String nickname;

    @OneToMany
    private List<Interest> interest;
}
