package com.example.appjambackend.global.util.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.example.appjambackend.global.security.exception.FileEmptyException;
import com.example.appjambackend.global.security.exception.FileUploadFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class S3Service {

//    private final AmazonS3 amazonS3;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    public String upload(MultipartFile image) throws IOException {
//        String fileName = UUID.randomUUID() + "-" + image.getOriginalFilename();
//
//        s3Client.putObject(new PutObjectRequest(bucket, fileName, image.getInputStream(), null)
//                .withCannedAcl(CannedAccessControlList.PublicRead));
//        return fileName;
//    }
//
//    public String delete(String imagePath) {
//        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, imagePath);
//        s3Client.deleteObject(deleteObjectRequest);
//        return "delete success:"+deleteObjectRequest.getKey();
//    }

}

