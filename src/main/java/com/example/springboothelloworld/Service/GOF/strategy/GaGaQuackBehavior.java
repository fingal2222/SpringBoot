package com.example.springboothelloworld.Service.GOF.strategy;

public class GaGaQuackBehavior  implements  QuackBehavior{
    @Override
    public void quack() {
        System.out.println("GaGa quack");
    }
}
