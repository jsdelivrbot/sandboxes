package com.example.aws.service;

import java.util.List;

import com.amazonaws.services.s3.model.Bucket;

public interface S3Service {
    
    Bucket createBucket(String name);
    List<Bucket> listAllBuckets();
    Bucket getBucket(String bucketName);
}
