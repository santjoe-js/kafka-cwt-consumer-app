/**
 * 
 */
package com.cwt.kafka.consumer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cwt.kafka.consumer.entity.Customer;
import com.cwt.kafka.consumer.entity.Employee;

/**
 * @author SJOSEP39
 *
 */
@Repository
public class CustomerRepository {
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;
	
    public Customer save(Customer customer) {
        dynamoDBMapper.save(customer);
        return customer;
    }

}
