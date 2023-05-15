package com.example.appjambackend.global.util.s3;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.appjambackend.domain.image.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class S3Service {
    private AmazonS3 s3Client;

    @Value("${cloud.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    public String upload(MultipartFile image){
        String fileName = UUID.randomUUID() + "-" + image.getOriginalFilename();

        try {
            s3Client.putObject(new PutObjectRequest(bucket, fileName, image.getInputStream(), null)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        return fileName;
    }

    public String delete(String imagePath) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, imagePath);
        s3Client.deleteObject(deleteObjectRequest);
        return "delete success:"+deleteObjectRequest.getKey();
    }

    public String getFileUrl(String fileName) {
        return s3Client.getUrl(bucket, fileName).toString();
    }

}

