package com.example.aws.service.dynamo.v2;

import java.util.List;

import software.amazon.awssdk.services.dynamodb.model.TableDescription;

public interface DynamoDbService {

    TableDescription createTable(String tableName);

    List<String> listAllTables();
}
