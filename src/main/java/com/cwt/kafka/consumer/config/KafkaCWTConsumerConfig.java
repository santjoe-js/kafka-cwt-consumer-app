/**
 * 
 */
package com.cwt.kafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.amazonaws.util.EC2MetadataUtils;
import com.cwt.kafka.consumer.model.EmployeeJSONModel;

/**
 * @author SJOSEP39
 *
 */
@Configuration
@EnableKafka
public class KafkaCWTConsumerConfig {
	
//	@Value("{Kafka.Broker.Address}")
//	private String kafkaBrokerAddress;
	
	
//	public KafkaCWTConsumerConfig() {
//		// Resolve the instanceId
//		String instanceId = EC2MetadataUtils.getInstanceId();
//
//		// Resolve (first/primary) private IP
//		String privateAddress = EC2MetadataUtils.getInstanceInfo().getPrivateIp();
//		
//	}
	
	@Bean
	public ConsumerFactory<String, EmployeeJSONModel> consumerFactoryJson(){
		
		Map<String, Object> configProps = new HashMap<String, Object>();
		//configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092");
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"employee_group_json");          
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		//configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example");
		//configProps.put(ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG,3000);
		
		//return  new DefaultKafkaConsumerFactory<>(configProps);
        return new DefaultKafkaConsumerFactory<>(configProps, 
                new StringDeserializer(), 
                new JsonDeserializer<>(EmployeeJSONModel.class,false));
	}
 
	
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, EmployeeJSONModel> 
                        employeeKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EmployeeJSONModel> factory 
            = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryJson());
        return factory;
    }
	
	
	/**
	 * for String
	 * 
	 */
	
	@Bean
	public ConsumerFactory<String, String> consumerFactoryString(){
		
		Map<String, Object> configProps = new HashMap<String, Object>();
		//configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092");
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"employee_group_json");          
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example");
		//configProps.put(ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG,3000);
		
		//return  new DefaultKafkaConsumerFactory<>(configProps);
        return new DefaultKafkaConsumerFactory<>(configProps, 
                new StringDeserializer(), 
                new StringDeserializer());
	}
 
	
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> 
                        employeeKafkaListenerStringContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factoryString 
            = new ConcurrentKafkaListenerContainerFactory<>();
        factoryString.setConsumerFactory(consumerFactoryString());
        return factoryString;
    }
	
	
}
