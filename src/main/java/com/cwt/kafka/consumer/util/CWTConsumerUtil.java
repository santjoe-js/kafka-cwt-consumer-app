/**
 * 
 */
package com.cwt.kafka.consumer.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentialsProvider;
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

@Component
public class CWTConsumerUtil {

	public String getCurentDate() {
		 Date date = Calendar.getInstance().getTime();  
		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		 return dateFormat1.format(date);  
	}
	
	
	public void findDifference(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);
			long difference_In_Time = d2.getTime() - d1.getTime();
			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
			if(difference_In_Seconds > 30)
			{
				System.out.println("sms triggered");
				triggerSMS();
			}
//			
//			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
//			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
//			long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
//			long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;
//			System.out.print("Difference" + " between two dates is: ");
//			System.out.println(difference_In_Years + " years, " + difference_In_Days + " days, " + difference_In_Hours
//					+ " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public void triggerSMS() {
		BasicAWSCredentials  basicAWSCredentials = new BasicAWSCredentials("AKIAS5FDYDBJNZGELN6J","ZvdpIUtvesUk+Rk16WOJeGR3v3wMTsmIMgEcb5Iv");
		System.out.println("sms triggered111111111111");
		AmazonSNS snsClient = AmazonSNSClient
				.builder()
				.withRegion(Regions.AP_SOUTHEAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
				.build();
		System.out.println("sms triggered22222222222");
		String smsMessage ="HI how are you new sms";
		System.out.println("sms triggered3333333333333333");
		String mobile="+919840345388";
		System.out.println("sms triggered44444444444444");
		
		snsClient.publish(new PublishRequest().withMessage(smsMessage).withPhoneNumber(mobile));
		System.out.println("sms triggered555555555555");
	}

}
