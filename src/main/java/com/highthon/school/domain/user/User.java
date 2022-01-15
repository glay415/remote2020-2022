package com.highthon.school.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class User {
    @Id
    private String id;
    private String password;
    private String nickname;
}
