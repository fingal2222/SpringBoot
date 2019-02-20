package com.example.springboothelloworld.Service.GOF.strategy;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public  void fly()
    {
        flyBehavior.fly();
    }
    public  void quack()
    {
        quackBehavior.quack();
    }

    public  abstract  void display();
    public  void  setFlyBehavior(FlyBehavior fly)
    {
        this.flyBehavior=fly;
    }
    public  void setQuackBehavior(QuackBehavior qb)
    {
        this.quackBehavior=qb;
    }
    public  void  swim()
    {
        System.out.println("im swim");
    }

}
