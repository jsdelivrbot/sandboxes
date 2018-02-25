package com.example.aws.service.s3.v2;

import java.util.List;

import software.amazon.awssdk.services.s3.model.Bucket;

public interface S3Service {
    
    String createBucket(String name);
    List<Bucket> listAllBuckets();
//    Bucket getBucket(String bucketName);
}
