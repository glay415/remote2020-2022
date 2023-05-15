package com.example.appjambackend.domain.feed.entity;

import com.example.appjambackend.domain.comment.entity.Comment;
import com.example.appjambackend.domain.image.entity.Image;
import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
    private List<Image> images;

    @Builder
    public Feed(String title, String description, User user) {
        this.title = title;
        this.description = description;
    }

    public void UploadImage(List<Image> images) {
        this.images = images;
    }

    public Feed changeTitle(String title) {
        this.title = title;
        return this;
    }

    public Feed changeDescription(String description) {
        this.description = description;
        return this;
    }
}
