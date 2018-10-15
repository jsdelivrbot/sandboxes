package com.example.aws.service.rds.v2;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.services.rds.RDSAsyncClient;
import software.amazon.awssdk.services.rds.RDSClient;

@Component
public class RdsServiceImpl implements RdsService {
    
    RDSAsyncClient asyncClient;
    RDSClient client;
    
    @Override
    public void createTable(String tableName) {
        
    }
}
