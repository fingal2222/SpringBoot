package com.example.springboothelloworld.Service.Webnet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        InetAddress address2=InetAddress.getByName("www.163.com");
        System.out.println(address2.getHostName());
        System.out.println(address2.getHostAddress());
    }
}
