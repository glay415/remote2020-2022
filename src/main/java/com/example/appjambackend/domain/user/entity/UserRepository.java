package com.example.appjambackend.domain.user.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserid(String userId);
}
