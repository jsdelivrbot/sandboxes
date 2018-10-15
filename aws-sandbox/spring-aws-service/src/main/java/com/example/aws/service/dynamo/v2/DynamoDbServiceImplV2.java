package com.example.aws.service.dynamo.v2;

import java.util.List;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDBClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.TableDescription;

@Service
public class DynamoDbServiceImplV2 implements DynamoDbService {

    private final DynamoDBClient client;
    private static final Region region = Region.US_WEST_2;

    public DynamoDbServiceImplV2() {
        client = DynamoDBClient.builder().region(region).build();
    }

    public TableDescription createTable(String tableName) {
        
        CreateTableRequest request = CreateTableRequest.builder()
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("Name")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .keySchema(KeySchemaElement.builder()
                        .attributeName("Name")
                        .keyType(KeyType.HASH)
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(10L)
                        .writeCapacityUnits(10L)
                        .build())
                .tableName(tableName)
                .build();

        CreateTableResponse response = client.createTable(request);
        return response.tableDescription();
    }

    @Override
    public List<String> listAllTables() {
        ListTablesResponse response = client.listTables();
        return response.tableNames();
    }
}
