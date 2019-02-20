package com.example.springboothelloworld.Service.GOF.Inspect;

import java.util.ArrayList;

public class WeatherDataSt implements Subject {
    private float mTemperature;
    private float mPressure;
    private float mHumidty;

    private ArrayList<Observer> arrayList;

    public WeatherDataSt() {
        arrayList = new ArrayList<>();
    }

    public float getmHumidty() {
        return mHumidty;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public void datachange() {
        notifyObserver();
    }

    public void setData(float mTemperature, float mPressure, float mHumidty) {
        this.mTemperature = mTemperature;
        this.mHumidty = mHumidty;
        this.mPressure = mPressure;
        datachange();
    }

    @Override
    public void registerObserver(Observer o) {
        arrayList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (arrayList.contains(o)) {
            arrayList.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < arrayList.size(); i++)
        {
            Observer observer = arrayList.get(i);
            observer.update(getmTemperature(), getmPressure(), getmHumidty());
        }
    }
}
