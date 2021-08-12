package com.cwt.kafka.consumer.customprgs;

import java.net.InetAddress;

class IPAddressExample {
    public static void main(String args[]) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
    }
}
