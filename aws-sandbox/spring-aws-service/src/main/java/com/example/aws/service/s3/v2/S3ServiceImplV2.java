package com.example.aws.service.s3.v2;

import java.util.List;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;


@Service
public class S3ServiceImplV2 implements S3Service {

    private final S3Client client;
    //TODO: make this a config option
    private static final Region region = Region.US_WEST_2;
    
    public S3ServiceImplV2() {
        client = S3Client.builder().region(region).build();
    }

    @Override
    public String createBucket(String bucketName) {
        CreateBucketRequest createBucketRequest = CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .createBucketConfiguration(CreateBucketConfiguration.builder()
                        .locationConstraint(region.value())
                        .build())
                .build();
        CreateBucketResponse response = client.createBucket(createBucketRequest);
        return response.location();
    }

    @Override
    public List<Bucket> listAllBuckets() {
        ListBucketsResponse listBucketsResponse = client.listBuckets();
        return listBucketsResponse.buckets();
    }
}
