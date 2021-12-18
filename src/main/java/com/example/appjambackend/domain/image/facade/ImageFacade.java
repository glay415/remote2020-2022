package com.example.appjambackend.domain.image.facade;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.entity.FeedRepository;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.image.entity.Image;
import com.example.appjambackend.domain.image.entity.ImageRepository;
import com.example.appjambackend.domain.user.entity.User;
import com.example.appjambackend.domain.user.facade.UserFacade;
import com.example.appjambackend.global.config.S3Config;
import com.example.appjambackend.global.security.exception.FileEmptyException;
import com.example.appjambackend.global.security.exception.TooManyFilesException;
import com.example.appjambackend.global.util.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImageFacade {

//    private final S3Service s3Service;
//=    private final FeedRepository feedRepository;
//    private final UserFacade userFacade;
//    private final FeedFacade feedFacade;
//
//    public void uploadImage(List<MultipartFile> files, Long feedId) {
//        User user = userFacade.getCurrentStudent();
//
//        Feed feed = feedFacade.getFeedId(feedId);
//
//        if (files.size() > 20) {
//            throw FileNumberExceedException.EXCEPTION;
//        }
//        deleteImage(post.getPetImages());
//
//        try {
//            for (MultipartFile file : files) {
//                ImageRepository.save(
//                        new PetImage(post, s3Service.upload(file)));
//            }
//        } catch (IOException e) {
//            petInfoRepository.delete(post.getPetInfo());
//            postRepository.delete(post);
//            deleteImage(post.getPetImages());
//            throw FileSaveFailedException.EXCEPTION;
//        }
//
//        addRoomPhoto(feed);
//    }
//
//    public void deleteImage(List<Image> petImages) {
//        for (PetImage petImage : petImages) {
//            s3Service.delete(petImage.getPath());
//            ImageRepository.delete(petImage);
//        }
//    }

}