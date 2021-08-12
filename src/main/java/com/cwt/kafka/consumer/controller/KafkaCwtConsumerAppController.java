/**
 * 
 */
package com.cwt.kafka.consumer.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwt.kafka.consumer.config.KafkaCWTConsumer;
import com.cwt.kafka.consumer.entity.Customer;
import com.cwt.kafka.consumer.entity.Employee;
import com.cwt.kafka.consumer.repository.CustomerRepository;
import com.cwt.kafka.consumer.repository.EmployeeRepository;
import com.cwt.kafka.consumer.util.CWTConsumerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SJOSEP39
 *
 */

@RestController
@Configuration
public class KafkaCwtConsumerAppController {

	
	Logger logger = LoggerFactory.getLogger(KafkaCwtConsumerAppController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CWTConsumerUtil cwtConsumerUtil;
	
	@Autowired
	Customer customer;
	
	@Autowired
	KafkaCWTConsumer kafkaCWTConsumer;

	@GetMapping("/test")
	public ResponseEntity<String> getDisplay() {
		System.out.println("entered into dispalyA");
//		return "democonfiserver";
		return new ResponseEntity<String>("This is a String", HttpStatus.OK);
		
		
	}
	
	@GetMapping("/")
    public String index(Model model) {
		System.out.println("dffdsfds");
		logger.info("logger info");
		logger.debug("logger debug");
		logger.error("logger error");
		logger.trace("logger trace");
		logger.warn("logger warn");
		
				
				
						
		return "index2";
    }
	
	
	@RequestMapping("/smsConnect")
    public String smsconnect(Model model) {
		System.out.println("sms triggered");
		//cwtConsumerUtil.triggerSMS();
		return "SMS connect endded";
	}
	
	
	@RequestMapping("/abcd")
    public String index2(Model model) {
		System.out.println("*************");
		try {
		customerRepository.save(new Customer("Santhosh", "Smith"));
		customerRepository.save(new Customer("Sant1", "Smith"));
		
		System.out.println("-------------------------------");
		
		employeeRepository.save(new Employee("firstname1", 1000, true));
		employeeRepository.save(new Employee("firstname2", 2000, false));

	    // fetch all customers
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
//	    for (Customer customer : customerRepository. .find()) {
//	      System.out.println(customer);
//	    }
	    System.out.println();
	    
		}catch(Exception e) {
			System.out.println("message wwwww " + e.getMessage());
			System.out.println();
			System.out.println();
			
			e.printStackTrace();
			System.out.println();
			System.out.println();
			System.out.println("stactrace " + e.getStackTrace());
			
		}
		model.addAttribute("Date", new Date());
		return "index2";
    }
	
	@RequestMapping("/test123")
    public String indexTest123(Model model) {
		
		System.out.println("dffdsfds - ********* test 123");
		logger.info("logger info");
		logger.error("logger error");
		logger.warn("logger warn");
		
		logger.debug("logger debug");
		logger.trace("logger trace");
		
		
		
		System.out.println("*************222222222222");
		model.addAttribute("STANDARD_DATE", new Date());
		return "index2";
    }
	
	@PostMapping(path= "/producerjsonstring")
	public String publishSend(@RequestBody String employeeJsonString) {
		try {
			System.out.println("entered into sample json");
			ObjectMapper mapper = new ObjectMapper();
			kafkaCWTConsumer.insertStringCloud(employeeJsonString);
			System.out.println("entered into sample json " + employeeJsonString); 
			return employeeJsonString;
		}catch(Exception e) {
			return "exception happend " + e;
		}
		
	}
	
	
	
}
