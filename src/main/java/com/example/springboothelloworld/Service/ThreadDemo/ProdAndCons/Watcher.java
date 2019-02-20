package com.example.springboothelloworld.Service.ThreadDemo.ProdAndCons;

public class Watcher implements Runnable {
    private  Movie m;

    public Watcher(Movie m) {
        super();
        this.m = m;
    }


    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            m.watch();
        }
    }
}
