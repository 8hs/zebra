package net.weever.zebra.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@DynamoDBDocument
public abstract class Notification {
    private String id;
    private long createDate;
    private String title;
    private String receiver;
    private String sender;

    @DynamoDBIgnore
    public static final String table_name = "Notification";

    @DynamoDBHashKey(attributeName = "rid")
    public String getReceiver() {
        return receiver;
    }

    @DynamoDBRangeKey(attributeName = "id")
    public String getId() {
        return id;
    }

}
