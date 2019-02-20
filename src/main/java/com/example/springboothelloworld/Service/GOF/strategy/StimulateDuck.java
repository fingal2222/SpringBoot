package com.example.springboothelloworld.Service.GOF.strategy;

public class StimulateDuck {
    public static void main(String[] args) {
        Duck greenHeadDuck = new GreenHeadDuck();
        Duck redHeadDuck = new RedHeadDuck();
        greenHeadDuck.display();
        greenHeadDuck.fly();
        greenHeadDuck.quack();
        greenHeadDuck.swim();

        redHeadDuck.display();
        redHeadDuck.fly();
        redHeadDuck.quack();
        redHeadDuck.swim();

        redHeadDuck.setFlyBehavior(new BadFlyBehavior());
        redHeadDuck.fly();

    }
}
