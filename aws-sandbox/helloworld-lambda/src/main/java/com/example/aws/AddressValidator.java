package com.example.aws;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Pattern;

public class AddressValidator implements RequestHandler<DynamodbEvent, String> {

    private static final String ADDRESS = "address";
    private static final String ID = "id";
    private static final String INSERT = "INSERT";
    private static final String TABLE_NAME = "US_Address_Table";
    private static final String ZIP_CODE_REGEX = "^[0-9]{5}(?:-[0-9]{4})?$";

    private DynamoDB dynamoDB;
    private Table table;

    @Override
    public String handleRequest(DynamodbEvent ddbEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        Pattern pattern = Pattern.compile(ZIP_CODE_REGEX);
        ObjectMapper objectMapper = new ObjectMapper();
        for (DynamodbStreamRecord record : ddbEvent.getRecords()) {
            try {
                if (record.getEventName().equals(INSERT)) {
                    if (null == dynamoDB) {
                        dynamoDB = new DynamoDB(new AmazonDynamoDBClient().withRegion(Regions.fromName(record.getAwsRegion())));
                        table = dynamoDB.getTable(TABLE_NAME);
                    }
                    Address address = objectMapper.readValue(record.getDynamodb().getNewImage().get(ADDRESS).getS().toString(), Address.class);
                    if (!Boolean.TRUE.equals(address.getValidated())) {
                        address.setValidated(pattern.matcher(address.getZipcode()).matches());
                        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                                .withPrimaryKey(ID, record.getDynamodb().getKeys().get(ID).getS())
                                .withUpdateExpression("set address = :a")
                                .withValueMap(new ValueMap().withString(":a", objectMapper.writeValueAsString(address)))
                                .withReturnValues(ReturnValue.UPDATED_NEW);
                        table.updateItem(updateItemSpec);
                    }
                }
            } catch (IOException e) {
                logger.log("Exception thrown when validating Zip Code. " + e.getMessage());
            }
        }
        return "Validated " + ddbEvent.getRecords().size() + " records.";
    }
}
