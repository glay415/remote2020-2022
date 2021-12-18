package com.example.appjambackend.domain.image.entity;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagePath;
    private String imageUrl;

    @JoinColumn(name = "feed_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Feed feed;

    @Builder
    public Image(String imagePath, String imageUrl, Feed feed) {
        this.imagePath = imagePath;
        this.imageUrl = imageUrl;
        this.feed = feed;
    }
}
