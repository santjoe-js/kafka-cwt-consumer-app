/**
 * 
 */
package com.cwt.kafka.consumer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cwt.kafka.consumer.entity.Employee;
import com.cwt.kafka.consumer.entity.MetEntity;

/**
 * @author SJOSEP39
 *
 */
@Repository
public class EmployeeRepository {
	
	@Autowired
    private DynamoDBMapper dynamoDBMapper;
	
    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }
    
    public MetEntity saveMet(MetEntity metEntity) {
    	dynamoDBMapper.save(metEntity);
        return metEntity;
    }

}
