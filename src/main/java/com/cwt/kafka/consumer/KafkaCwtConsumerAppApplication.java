package com.cwt.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cwt.kafka.consumer.repository.EmployeeRepository1;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.cwt.kafka.consumer"})
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = EmployeeRepository1.class)
public class KafkaCwtConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCwtConsumerAppApplication.class, args);
	}

}
