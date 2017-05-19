package net.weever.zebra.dao.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import net.weever.zebra.dao.NotificationDao;
import net.weever.zebra.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class NotificationDaoImpl <T extends Notification> implements NotificationDao < T >{

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    @Override
    public void insert(T notification) {
        dynamoDBMapper.save(notification);
    }

    @Override
    public void delete(T notification) {
        dynamoDBMapper.delete(notification);
    }

    @Override
    public List< T > findByReceiver(String receiver, int limit) {
        return null;
    }

    @Override
    public T findNoticiation(String receiver, String nid) {
        return null;
    }
}
