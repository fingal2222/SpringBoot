package com.example.springboothelloworld.Service.GOF.Decorator;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        super.setPrice(2.0f);
        super.setDescription("Milk");
    }

}
