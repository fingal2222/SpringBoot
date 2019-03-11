package com.example.springboothelloworld.Service.GOF.Adapter;

public class TurkeyAdapter implements Duck {
    private Turkey turkey;


    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {

        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 10; i++) {
            turkey.fly();
        }
    }
}
