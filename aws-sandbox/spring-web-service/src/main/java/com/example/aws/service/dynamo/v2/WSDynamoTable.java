package com.example.aws.service.dynamo.v2;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.services.dynamodb.model.TableDescription;

@Getter
@Setter
class WSDynamoTable {

    private String name;
    private String status;
    private String arn;
    
    public WSDynamoTable() {}
    
    public WSDynamoTable(String tableName) {
        this.name = tableName;
    }
    
    public WSDynamoTable(TableDescription tableDescription) {
        this.name = tableDescription.tableName();
        this.status = tableDescription.tableStatusString();
        this.arn = tableDescription.tableArn();
    }
}

