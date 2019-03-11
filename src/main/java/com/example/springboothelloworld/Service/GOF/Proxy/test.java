package com.example.springboothelloworld.Service.GOF.Proxy;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class test {
    public static void main(String[] args) {
        try {
            UserHandler userHandler = new UserHandlerImpl();
            LocateRegistry.createRegistry(6602);
            Naming.bind("rmi://127.0.0.1:6602/user",userHandler);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
