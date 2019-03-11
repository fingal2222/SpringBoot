package com.example.springboothelloworld.Service.GOF.Decorator;

public class Sugar extends  Decorator {

    public Sugar(Drink obj) {
        super(obj);
        super.setDescription("sugar");
        super.setPrice(4.0f);
    }

    @Override
    public float cost() {
        return super.cost();
    }
}
