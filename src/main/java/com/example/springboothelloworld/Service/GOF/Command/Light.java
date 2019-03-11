package com.example.springboothelloworld.Service.GOF.Command;

public class Light {
    String loc="";

    public Light(String loc) {
        this.loc = loc;
    }
    public  void On()
    {
        System.out.println("open the "+loc+" light");
    }
    public  void Off()
    {
        System.out.println("close the "+loc+" light");
    }
}
