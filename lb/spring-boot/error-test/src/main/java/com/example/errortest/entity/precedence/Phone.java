package com.example.errortest.entity.precedence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "MANUFACTURER")
public class Phone {

    @Id @GeneratedValue
    protected Integer id;

    protected String profile;

    protected void setProfile(String profile) {
        this.profile = profile;
    }
}
