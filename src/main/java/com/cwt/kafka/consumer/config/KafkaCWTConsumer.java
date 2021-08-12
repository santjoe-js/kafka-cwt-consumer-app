/**
 * 
 */
package com.cwt.kafka.consumer.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cwt.kafka.consumer.entity.Employee;
import com.cwt.kafka.consumer.entity.MetEntity;
import com.cwt.kafka.consumer.model.EmployeeJSONModel;
import com.cwt.kafka.consumer.repository.EmployeeRepository;
import com.cwt.kafka.consumer.repository.MetRepository;
import com.cwt.kafka.consumer.util.CWTConsumerUtil;

/**
 * @author SJOSEP39
 *
 */

@Service
public class KafkaCWTConsumer {
	
//	@Autowired
//	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	MetRepository metRepository;
	
	@Autowired
	CWTConsumerUtil cwtConsumerUtil;
	
	public String last_Date_Time_Queue;
	
//	@KafkaListener(topics="helloTopic", groupId="consumer-group")
//	public void consume(String consumeMessage) {
//		
//		insertCloud(consumeMessage);
//		
//		System.out.println("consumed message "+ consumeMessage);
//	}
//	
//	@KafkaListener(topics="helloTopic", groupId="employee_group_json",
//			containerFactory ="employeeKafkaListenerContainerFactory")
//    public void onReceive(Transaction transaction) {
//        //LOGGER.info("transaction = {}",transaction);
//    }
	
	
	
	@KafkaListener(topics="helloTopic", groupId="employee_group_json",
			containerFactory ="employeeKafkaListenerContainerFactory")
	public void consume(EmployeeJSONModel employeeJSONModel) {
		
		try {
			System.out.println(employeeJSONModel);
			last_Date_Time_Queue =cwtConsumerUtil.getCurentDate();
			//insertJSONCloud(employeeJSONModel);
			System.out.println("consumed message " + employeeJSONModel);
		}catch(Exception e) {
			System.out.println("******************//////////////************");
			System.out.println(e.getMessage());
			System.out.println("******************//////////////************");
		}
		
	
	}
	
	
	public void insertJSONCloud(EmployeeJSONModel employeeJSONModel) {
		System.out.println("*************");
		try {
			
			employeeRepository.save((Employee) new Employee(employeeJSONModel.getName(),employeeJSONModel.getSalary(),employeeJSONModel.isMartialStatus()));
//		customerRepository.save(new Customer(strArray[0], strArray[1]));
	//	customerRepository.save(new Customer("Sant1", "Smith"));
	    // fetch all customers
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
//	    for (Employee emp : employeeRepository.findAll()) {
//	      System.out.println(emp);
//	    }
	    System.out.println();
	    
		}catch(Exception e) {
			System.out.println("message " + e.getMessage());
			System.out.println();
			System.out.println("stactrace " + e.getStackTrace());
		}
	}
	
	public void insertCloud(String consumeMessage) {
		System.out.println("*************");
		try {
			
			String[] strArray = consumeMessage.split("-"); 
		//customerRepository.save(new Customer(strArray[0], strArray[1]));
	//	customerRepository.save(new Customer("Sant1", "Smith"));
	    // fetch all customers
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
//	    for (Customer customer : customerRepository.findAll()) {
//	      System.out.println(customer);
//	    }
	    System.out.println();
		}catch(Exception e) {
			System.out.println("message " + e.getMessage());
			System.out.println();
			System.out.println("stactrace " + e.getStackTrace());
		}
	}
	
	
	
	/**
	 * String code
	 */
	@KafkaListener(topics="helloTopic", groupId="employee_group_json",
			containerFactory ="employeeKafkaListenerStringContainerFactory")
	public void consume(String jsonString) {
		
		try {
			last_Date_Time_Queue =cwtConsumerUtil.getCurentDate();
			insertStringCloud(jsonString);
			System.out.println("consumed message " + jsonString);
		}catch(Exception e) {
			System.out.println();
			System.out.println("******************//////////////************");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("******************//////////////************");
		}
		
	
	}
	
	
	
	public void insertStringCloud(String  jsonString) {
		
		try {
			employeeRepository.saveMet((MetEntity) new MetEntity(jsonString,true));
			
	    // fetch all customers
	    System.out.println("db insertion done........");
	    System.out.println("-------------------------------");
//	    for (Employee emp : employeeRepository.findAll()) {
//	      System.out.println(emp);
//	    }
	    System.out.println();
	    
		}catch(Exception e) {
			System.out.println("message " + e.getMessage());
			System.out.println();
			System.out.println("stactrace " + e.getStackTrace());
		}
	}

}
