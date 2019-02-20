package com.example.springboothelloworld.Service.GOF.strategy;

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("good fly");
    }
}
