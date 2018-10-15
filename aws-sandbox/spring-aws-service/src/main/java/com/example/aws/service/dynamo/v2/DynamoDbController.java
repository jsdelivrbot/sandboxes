package com.example.aws.service.dynamo.v2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.dynamodb.model.TableDescription;

@RestController
public class DynamoDbController {
    
    private DynamoDbService service;
    
    @Autowired
    public DynamoDbController(DynamoDbService service) {
        this.service = service;
    }

    @PostMapping("/dynamodb/table")
    public WSDynamoTable createBucket(@RequestBody WSDynamoTable request) {
        TableDescription table = service.createTable(request.getName());
        return new WSDynamoTable(table);
    }

    @RequestMapping("/dynamodb/table")
    public List<WSDynamoTable> listAllBuckets() {
        return service.listAllTables().stream()
                .map(WSDynamoTable::new)
                .collect(Collectors.toList());
    }
}
