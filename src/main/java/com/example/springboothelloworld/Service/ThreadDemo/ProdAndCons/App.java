package com.example.springboothelloworld.Service.ThreadDemo.ProdAndCons;

public class App {
    public  static  void main(String[] args)
    {
        /**
         * flag->T 生产者生产，消费者等待，生产者生产完通知消费者
         * flag->F生产者等待，消费者生产
         */


        Movie m=new Movie();
        Player p=new Player(m);
        Watcher w =new Watcher(m);
        new Thread(p).start();
        new Thread(w).start();
    }
}
