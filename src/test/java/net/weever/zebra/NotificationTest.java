package net.weever.zebra;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import net.weever.zebra.dao.dynamodb.ServerNotificationDaoImpl;
import net.weever.zebra.model.ServerNotification;
import net.weever.zebra.model.UserNotification;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by localadmin on 5/18/17.
 */
public class NotificationTest extends BaseTest{

    @Test
    public void TestSave(){
        DynamoDBMapper dynamoDBMapper = dynamoDBMapper();
        createTable(dynamoDBMapper);
        ServerNotification notice = new ServerNotification();
        notice.setId(new ObjectId().toHexString());
        notice.setReceiver(UUID.randomUUID().toString());
        notice.setAlert("Server");

        UserNotification userNotice = new UserNotification();
        userNotice.setId(new ObjectId().toHexString());
        userNotice.setReceiver(UUID.randomUUID().toString());
        userNotice.setGift("USER");

        dynamoDBMapper.save(notice);
        dynamoDBMapper.save(userNotice);

        ServerNotification r1 = dynamoDBMapper.load(ServerNotification.class,notice.getReceiver(), notice.getId());
        UserNotification r2 = dynamoDBMapper.load(UserNotification.class, userNotice.getReceiver(),userNotice.getId());
    }


    public boolean createTable(DynamoDBMapper dynamoDBMapper) {
        try {
            CreateTableRequest tableRequest =  dynamoDBMapper.generateCreateTableRequest(ServerNotification.class); // 1
            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1000L, 1500L)); // 2
            amazonDynamoDBClient().createTable(tableRequest); // 3

        } catch (Error e) {
            e.printStackTrace();
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
