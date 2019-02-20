package com.example.springboothelloworld.Service.GOF.strategy;

public class RedHeadDuck extends  Duck {
    public RedHeadDuck() {
        flyBehavior=new GoodFlyBehavior();
        quackBehavior=new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("RedHeadDuck");
    }
}
