package com.example.appjambackend.domain.mark.entity;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name="mark_uk",
                        columnNames = {"feed_id", "user_id"}
                )
        }
)
public class Mark extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "feed_id")
    @ManyToOne
    private Feed feed;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    public Mark(Feed feed, User user) {
        this.feed = feed;
        this.user = user;
    }
}
