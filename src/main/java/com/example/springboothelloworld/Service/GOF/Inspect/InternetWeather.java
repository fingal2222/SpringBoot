package com.example.springboothelloworld.Service.GOF.Inspect;

public class InternetWeather {
    public static void main(String[] args) {
        CurrentConditions currentConditions;
        ForcastConditios forcastConditios;
        WeatherDataSt weatherDataSt=new WeatherDataSt();
        currentConditions=new CurrentConditions();
        forcastConditios=new ForcastConditios();

        weatherDataSt.registerObserver(currentConditions);
        weatherDataSt.registerObserver(forcastConditios);
        weatherDataSt.setData(10,20,30);

        weatherDataSt.removeObserver(currentConditions);
        weatherDataSt.setData(20,50,100);

    }
}
