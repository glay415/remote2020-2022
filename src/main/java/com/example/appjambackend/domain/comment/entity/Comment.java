package com.example.appjambackend.domain.comment.entity;

import com.example.appjambackend.domain.feed.entity.Feed;
import lombok.*;


import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String nickname;

    @JoinColumn(name = "feed_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Feed feed;

}
