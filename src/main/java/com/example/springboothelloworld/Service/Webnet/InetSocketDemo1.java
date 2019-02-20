package com.example.springboothelloworld.Service.Webnet;

import java.net.InetSocketAddress;

public class InetSocketDemo1 {
    public static void main(String[] args) {
        InetSocketAddress address=new InetSocketAddress("127.0.0.1",9999);

        System.out.println(address.getHostName());
        System.out.println(address);
    }
}
