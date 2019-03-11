package com.example.springboothelloworld.Service.GOF.Proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserHandlerImpl extends UnicastRemoteObject implements UserHandler  {
    public UserHandlerImpl() throws RemoteException {
        super();
    }
    @Override
    public String getUserName(int id) throws RemoteException {
        return "lmy86263";
    }
    @Override
    public int getUserCount() throws RemoteException{
        return 1;
    }
    @Override
    public User getUserByName(String name) throws RemoteException{
        return new User("lmy86263", 1);
    }
}
