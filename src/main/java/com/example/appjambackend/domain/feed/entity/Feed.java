package com.example.appjambackend.domain.feed.entity;

import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 1000)
    private String description;

    @Builder
    public Feed(String title, String description, User user) {
        this.title = title;
        this.description = description;
    }

}
