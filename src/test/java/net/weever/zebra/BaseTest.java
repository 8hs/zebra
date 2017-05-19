package net.weever.zebra;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * Created by localadmin on 5/18/17.
 */
public class BaseTest {

    public AmazonDynamoDB amazonDynamoDBClient(){

        return AmazonDynamoDBClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(new BasicAWSCredentials("accesskey", "secretkey"))
            ).withEndpointConfiguration(
                new AwsClientBuilder
                        .EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .build();
    }

    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDBClient());
    }
}
