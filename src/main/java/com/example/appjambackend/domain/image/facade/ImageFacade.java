package com.example.appjambackend.domain.image.facade;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.image.entity.Image;
import com.example.appjambackend.domain.image.entity.ImageRepository;
import com.example.appjambackend.global.util.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ImageFacade {

    private final ImageRepository imageRepository;
    private final S3Service s3Service;

    @Transactional
    public void imageUpload(List<MultipartFile> images, Feed feed) {

        feed.UploadImage(
                images.stream()
                        .map(s3Service::upload)
                        .map(imagePath -> imageRepository.save(Image.builder()
                                .imagePath(imagePath)
                                .imageUrl(s3Service.getFileUrl(imagePath))
                                .build()))
                        .collect(Collectors.toList())
        );
    }

}