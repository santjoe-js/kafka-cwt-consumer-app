/**
 * 
 */
package com.cwt.kafka.consumer.Scheduler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cwt.kafka.consumer.config.KafkaCWTConsumer;
import com.cwt.kafka.consumer.util.CWTConsumerUtil;

/**
 * @author SJOSEP39
 *
 */
@Component
public class CWTKafkaConsumerScheduler {

	@Autowired
	KafkaCWTConsumer KafkaCWTConsumer;
	
	@Autowired
	CWTConsumerUtil cwtConsumerUtil;

	/**
	 * Test every 5 sec.
	 */
	@Scheduled(cron = "*/60 * * * * *") // every 5 seconds
	public void triggerEvery30Sec() {

		System.out.println("Every 30 Secs ******** ");

		if(KafkaCWTConsumer.last_Date_Time_Queue!=null) {
			String dateCurrentInSch=cwtConsumerUtil.getCurentDate();
			cwtConsumerUtil.findDifference(KafkaCWTConsumer.last_Date_Time_Queue,dateCurrentInSch);
		}else {
			KafkaCWTConsumer.last_Date_Time_Queue=cwtConsumerUtil.getCurentDate();
		}
	}

	

}
