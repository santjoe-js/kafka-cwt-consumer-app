/**
 * 
 */
package com.cwt.kafka.consumer.customprgs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

/**
 * @author SJOSEP39
 *
 */
public class AmazonSMS1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("sms triggered");
		BasicAWSCredentials  basicAWSCredentials = new BasicAWSCredentials("AKIAS5FDYDBJNZGELN6J","ZvdpIUtvesUk+Rk16WOJeGR3v3wMTsmIMgEcb5Iv");
		
		AmazonSNS snsClient = AmazonSNSClient
				.builder()
				.withRegion(Regions.AP_SOUTHEAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
		
		String smsMessage ="Hi how are you. Please check ???";
		
		String mobile="+919840345388";
		snsClient.publish(new PublishRequest().withMessage(smsMessage).withPhoneNumber(mobile));
		
//		mobile="+919790479107";
//		snsClient.publish(new PublishRequest().withMessage(smsMessage).withPhoneNumber(mobile));
		System.out.println("sms triggered555555555555");


	}

}
