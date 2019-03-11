package com.example.springboothelloworld.Service.GOF.Adapter;

public class WildTurkey implements  Turkey {
    @Override
    public void gobble() {
        System.out.println("i am a turky,i can quack gogo!");
    }

    @Override
    public void fly() {
        System.out.println("i am a turkey, i can fly a short distance!");
    }
}
