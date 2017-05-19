package net.weever.zebra.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@DynamoDBTable(tableName = Notification.table_name)
@Setter @Getter
public class UserNotification extends Notification {
    private String gift;
}
