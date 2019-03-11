package com.example.springboothelloworld.Service.GOF.Proxy;

import java.rmi.Naming;

public class client {
    public static void main(String[] args) {
        try {
            UserHandler handler = (UserHandler) Naming.lookup("rmi://127.0.0.1:6602/user");
            int count = handler.getUserCount();
            String name = handler.getUserName(1);
            System.out.println("name: " + name);
            System.out.println("count: " + count);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
