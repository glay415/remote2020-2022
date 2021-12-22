package com.example.appjambackend.domain.image.entity;

import com.example.appjambackend.domain.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    void deleteByFeed(Feed feed);
}
