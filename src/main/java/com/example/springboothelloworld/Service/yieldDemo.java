package com.example.springboothelloworld.Service;


import org.springframework.stereotype.Component;

@Component
public  class yieldDemo implements Runnable{
    int count = 10;
    public synchronized void run() {
        while (true) {
            if(count>0){
                System.out.println(Thread.currentThread().getName() + count-- + "个瓜");
                if(count % 2 == 0){
                    Thread.yield();
                }
            }
        }
    }
}