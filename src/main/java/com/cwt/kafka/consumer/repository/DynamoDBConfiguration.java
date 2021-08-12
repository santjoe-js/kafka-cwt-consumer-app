/**
 * 
 */
package com.cwt.kafka.consumer.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * @author SJOSEP39
 *
 */

@Configuration
public class DynamoDBConfiguration {
	
	 @Bean
	  public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDB()); 
	 }
	 
	 private AmazonDynamoDB buildAmazonDynamoDB() {
		 return AmazonDynamoDBClientBuilder
				 .standard()
				 .withEndpointConfiguration(
						 new AwsClientBuilder.EndpointConfiguration(
								 "dynamodb.us-east-2.amazonaws.com",
								 "us-east-2"
								 )
				  )
				 .withCredentials(
	                        new AWSStaticCredentialsProvider(
	                                new BasicAWSCredentials(
	                                        "AKIAS5FDYDBJNZGELN6J",
	                                        "ZvdpIUtvesUk+Rk16WOJeGR3v3wMTsmIMgEcb5Iv"
	                                )
	                        )
	                )
	                .build();
	 }

}
