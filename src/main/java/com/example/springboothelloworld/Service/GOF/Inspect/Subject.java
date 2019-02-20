package com.example.springboothelloworld.Service.GOF.Inspect;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
