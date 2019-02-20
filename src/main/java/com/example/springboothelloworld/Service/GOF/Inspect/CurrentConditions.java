package com.example.springboothelloworld.Service.GOF.Inspect;

public class CurrentConditions implements Observer {
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
        System.out.println("***mTemperature***"+mTemperature);
        System.out.println("***mHumidty***"+mHumidty);
        System.out.println("***mPressure***"+mPressure);
    }
}
