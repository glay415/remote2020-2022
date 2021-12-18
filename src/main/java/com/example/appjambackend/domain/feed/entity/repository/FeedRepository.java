package com.example.appjambackend.domain.feed.entity.repository;

import com.example.appjambackend.domain.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {


}
