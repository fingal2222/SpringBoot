package com.example.springboothelloworld.Service.GOF.Adapter;

public class GreenHeadDuck implements   Duck {
    @Override
    public void quack() {
        System.out.println("i am a duck ,i can quack gaga!");
    }

    @Override
    public void fly() {
        System.out.println("i am a duck i can fly a long distance!");
    }
}
