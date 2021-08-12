

import java.io.File;
import java.net.InetAddress;

class IPAddressExample {
    public static void main(String args[]) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
        
        
        File homedir = new File(System.getProperty("java.class.path"));
        
        File fileToRead = new File(homedir, "java/ex.txt");
    }
}
