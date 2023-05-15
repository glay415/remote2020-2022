package com.example.appjambackend.domain.like.entity;

import com.example.appjambackend.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Long> {
    List<Like> findByUser(User user);
}
