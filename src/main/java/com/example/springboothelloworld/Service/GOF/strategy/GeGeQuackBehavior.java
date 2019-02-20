package com.example.springboothelloworld.Service.GOF.strategy;

public class GeGeQuackBehavior implements  QuackBehavior {
    @Override
    public void quack() {
        System.out.println("gege quack");
    }
}
