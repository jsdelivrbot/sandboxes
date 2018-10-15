package com.example.aws.service.s3.v2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3Controller {
    
    private S3Service s3Service;
    
    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/s3/bucket")
    public String createBucket(@RequestBody WSCreateBucketRequest request) {
        return s3Service.createBucket(request.getName());
    }

    @RequestMapping("/s3/bucket")
    public List<WSCreateBucketResponse> listAllBuckets() {
        return s3Service.listAllBuckets().stream()
                .map(WSCreateBucketResponse::new)
                .collect(Collectors.toList());
    }
}
