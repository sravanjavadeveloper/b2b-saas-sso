package com.b2bsaasapp.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *
 * @author sravanrao
 *
 */

@Configuration
    public class DynamoDBConfig {

        @Value("${cloud.aws.region.static}")
        private String amazonAWSRegion;
        @Value("${cloud.aws.credentials.accessKey}")
        private String accessKey;
        @Value("${cloud.aws.credentials.secretKey}")
        private String secretKey;

        @Bean
        public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
            return new DynamoDBMapper(amazonDynamoDB);
        }

        @Bean
        public AmazonDynamoDB amazonDynamoDB() {
            AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                    .withRegion(amazonAWSRegion)
                     .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                    .build();
            return amazonDynamoDB;

        }
    }


