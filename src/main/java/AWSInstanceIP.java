/**
 * 
 */


import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.Address;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

/**
 * @author SJOSEP39
 *
 */
public class AWSInstanceIP {
	
	
	public static void main(String[] args) {
		
		try {
			System.out.println("IP getting");
			BasicAWSCredentials  basicAWSCredentials = new BasicAWSCredentials("AKIAS5FDYDBJNZGELN6J","ZvdpIUtvesUk+Rk16WOJeGR3v3wMTsmIMgEcb5Iv");
			//BasicAWSCredentials  basicAWSCredentials = new BasicAWSCredentials("AKIAS5FDYDBJLGEEUWFW","UUHwpdW6+kLCymOS8zA64P+WYJggimQtluwn2f8V");
			 AmazonEC2 ec2 =  AmazonEC2ClientBuilder
					 	.standard()
			            .withRegion(Regions.AP_SOUTHEAST_2)
			            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
			            .build();
			 
			 DescribeAddressesResult response = ec2.describeAddresses();
			 
			  //DescribeAddressesResult response = ec2.describeAddresses();
			  
			  System.out.println("IP getting11111111111");
			  for(Address address : response.getAddresses()) {
				  System.out.println("IP getting22222222222222222");
			      System.out.printf(
			              "Found address with public IP %s, " +
			              "domain %s, " +
			              "allocation id %s " +
			              "and NIC id %s",
			              address.getPublicIp(),
			              address.getDomain(),
			              address.getAllocationId(),
			              address.getNetworkInterfaceId());
			  }
			  
			  System.out.println("IP getttin333333333333");

			 
			 DescribeInstancesResult result = ec2.describeInstances();
		        List<Reservation> reservations = result.getReservations();

		        System.out.println("IP getttin4444444444444444");
		        List<Instance> instances;
		        System.out.println("IP getttin555555555555555555");
		        for(Reservation res : reservations){
		        	System.out.println("IP getttin7777777777777");
		            instances = res.getInstances();
		            for(Instance ins : instances){
		            	System.out.println("IP getttin88888888888888");
		            	System.out.println("PublicIP from " + ins.getImageId() + " is " + ins.getPublicIpAddress());
		            }
		            System.out.println("IP getttin99999999999999");
		        }
			
		}catch(Exception e) {
			System.out.println("exception " + e);
		}

		System.out.println("IP getttinenddddddddddddd...........************");
	}
	  
	  
	
}
