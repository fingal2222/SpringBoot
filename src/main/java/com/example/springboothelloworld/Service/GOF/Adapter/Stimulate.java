package com.example.springboothelloworld.Service.GOF.Adapter;

public class Stimulate {
    public static void main(String[] args) {
        WildTurkey turky=new WildTurkey();
        Duck adpter=new TurkeyAdapter(turky);
        adpter.quack();
        adpter.fly();
    }
}
