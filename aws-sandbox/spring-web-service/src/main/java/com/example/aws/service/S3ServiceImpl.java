package com.example.aws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

@Service
public class S3ServiceImpl implements S3Service {

    private final AmazonS3 s3;
    
    public S3ServiceImpl() {
        s3 = AmazonS3ClientBuilder.defaultClient();
        //s3 = AmazonS3ClientBuilder.standard().setRegion("fdg");
    }

    @Override
    public Bucket createBucket(String bucketName) {
        Bucket b = null;
        if (s3.doesBucketExistV2(bucketName)) {
            System.out.format("Bucket %s already exists.\n", bucketName);
            b = getBucket(bucketName);
        } else {
            try {
                b = s3.createBucket(bucketName);
            } catch (AmazonS3Exception e) {
                System.err.println(e.getErrorMessage());
            }
        }
        return b;
    }

    @Override
    public List<Bucket> listAllBuckets() {
        return s3.listBuckets();
    }

    @Override
    public Bucket getBucket(String bucketName) {
        //TODO: is there no other way to do this more efficiently?
        Bucket namedBucket = null;
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            if (b.getName().equals(bucketName)) {
                namedBucket = b;
            }
        }
        return namedBucket;
    }
}
