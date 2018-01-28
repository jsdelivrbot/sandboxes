package com.example.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.example.aws.service.S3Service;

@RestController
public class S3Controller {
    
    private S3Service s3Service;
    
    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/s3/bucket")
    public Bucket createBucket(@PathVariable String name) {
        return s3Service.createBucket(name);
    }

    @RequestMapping("/s3/bucket")
    public List<Bucket> listAllBuckets() {
        return s3Service.listAllBuckets();
    }

    @RequestMapping("/s3/bucket/{bucketName}")
    public Bucket getBucket(@PathVariable("bucketName") String bucketName) {
        return s3Service.getBucket(bucketName);
    }
}
