package com.example.aws.service.rds.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aws.service.s3.v2.WSCreateBucketRequest;

@RestController
public class RdsController {

    private RdsService rdsService;

    @Autowired
    public RdsController(RdsService rdsService) {
        this.rdsService = rdsService;
    }

    @PostMapping("/rds/table")
    public String createTable(@RequestBody WSCreateBucketRequest request) {
        return rdsService.createTable(request.getName());
    }
}
