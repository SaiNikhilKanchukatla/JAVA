/*Write a java function that will ping any host ( given as input )
 and computes the median of the time taken to ping.
Use the system ping utility, do not use any deprecated methods.
 */
package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the IP Address");
        String ipaddress = scanner.nextLine();//reading ipaddress
        computeTime(ipaddress);
    }

    private static void computeTime(String ipAddress) throws IOException {
        long currentTime = System.currentTimeMillis(); // Gives the current time in milli seconds
        InetAddress address = InetAddress.getByName(ipAddress);  //InetAddress class represents an IP address
        System.out.println("Sending Ping Request to " + ipAddress);
        if (address.isReachable(1000))
            System.out.println("Host is reachable");
        else
            System.out.println("Sorry ! We can't reach to this host");
        currentTime = System.currentTimeMillis() - currentTime; //calculating the time in milli seconds and subtracting currenttime so that we get the time taken to ping
        System.out.println("Time taken to ping the host:" + ipAddress + " is " + currentTime + " milliseconds");
    }

}
