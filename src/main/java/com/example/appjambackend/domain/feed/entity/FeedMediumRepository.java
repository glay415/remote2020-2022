package com.example.appjambackend.domain.feed.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedMediumRepository extends JpaRepository<FeedMedium, Long> {

    FeedMedium findFeedMediumByFeed(Feed feed);

    int countByFeed(Long feedId);
}
