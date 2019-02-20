package com.example.springboothelloworld.Service.GOF.strategy;

public class GreenHeadDuck extends  Duck {
    public GreenHeadDuck() {
        flyBehavior=new BadFlyBehavior();
        quackBehavior=new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("GreenHeadDuck");
    }
}
