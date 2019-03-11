package com.example.springboothelloworld.Service.GOF.Decorator;

public class Decorator extends Drink {
    private  Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice()+obj.getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"-"+super.getPrice()+"&&"+obj.getDescription();
    }
}
