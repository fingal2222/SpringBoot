package com.example.springboothelloworld.Service.GOF.Decorator;

public class Coffee extends Drink {

    @Override
    public float cost() {
return  super.getPrice();
    }
}
