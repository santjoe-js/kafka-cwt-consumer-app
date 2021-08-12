/**
 * 
 */
package com.cwt.kafka.consumer.customprgs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author SJOSEP39
 *
 */
public class TestDate1 {

	/**
	 * @param args
	 */
	
	
	public static String last_Date_Time_Queue;
	
	public static void main(String[] args) {
		 last_Date_Time_Queue = getCurentDate();  
		 System.out.println("firstdate " + last_Date_Time_Queue);
		 for (int i=0; i<=100000;i++) {
		}

			if(last_Date_Time_Queue!=null) {
				String dateCurrent=getCurentDate();
				System.out.println("dateCurrent " + dateCurrent);
				findDifference(last_Date_Time_Queue,dateCurrent);
			}
	}
	
	public static String getCurentDate() {
		 Date date = Calendar.getInstance().getTime();  
		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		 return dateFormat1.format(date);  
	}
	
	public static void findDifference(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);
			long difference_In_Time = d2.getTime() - d1.getTime();
			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
			if(difference_In_Seconds > 15)
			{
				System.out.println("sms triggered");
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

}
