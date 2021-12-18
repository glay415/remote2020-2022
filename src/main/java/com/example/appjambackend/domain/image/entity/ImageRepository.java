package com.example.appjambackend.domain.image.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    Optional<Image> findByImagePath(String imagePath);
}
