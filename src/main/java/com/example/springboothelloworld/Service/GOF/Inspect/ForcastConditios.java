package com.example.springboothelloworld.Service.GOF.Inspect;

public class ForcastConditios implements  Observer {
    private float mTemperature;
    private float mPressure;
    private float mHumidty;

    @Override
    public void update(float mTemperature, float mPressure, float mHumidty) {
        this.mTemperature = mTemperature;
        this.mHumidty = mHumidty;
        this.mPressure = mPressure;
        display();
    }
    private  void display()
    {
        System.out.println("*** tomorrow mTemperature***"+mTemperature+Math.random());
        System.out.println("***tomorrow mHumidty***"+mHumidty+Math.random());
        System.out.println("***tomorrowmPressure***"+mPressure+Math.random());
    }
}
