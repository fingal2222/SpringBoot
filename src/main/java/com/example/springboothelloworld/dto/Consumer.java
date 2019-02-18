package com.example.springboothelloworld.dto;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private  final BlockingQueue<Integer> queue;
    public  Consumer(BlockingQueue q)
    {
        this.queue=q;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                consume(queue.take());
            } catch (InterruptedException e) {

            }
        }
    }
    private void consume(Integer n) {
        System.out.println("Thread:" + Thread.currentThread().getId() + " consume:" + n);

    }
}
