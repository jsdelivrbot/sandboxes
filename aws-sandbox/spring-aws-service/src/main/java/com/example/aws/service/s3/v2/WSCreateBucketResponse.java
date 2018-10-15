package com.example.aws.service.s3.v2;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.services.s3.model.Bucket;

@Getter
@Setter
public class WSCreateBucketResponse {

    private String name;
    private Instant creationDate;
    
    public WSCreateBucketResponse(Bucket bucket) {
        this.name = bucket.name();
        this.creationDate = bucket.creationDate();
    }
}
