package com.example.appjambackend.domain.mark.entity;

import com.example.appjambackend.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Long> {
    List<Mark> findByUser(User user);
}
