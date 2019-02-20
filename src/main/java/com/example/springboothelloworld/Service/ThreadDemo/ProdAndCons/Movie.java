package com.example.springboothelloworld.Service.ThreadDemo.ProdAndCons;

public class Movie {
    private  boolean flag=true;
    private  static String pic;
    public synchronized void  play(String pic)
    {
        if (!flag)//生产者等待
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic=pic;
        //通知消费者
        this.notify();
        //停止生产
        this.flag=false;
    }
    public   synchronized void watch()
    {
        if (flag)//消费者等待
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pic);
        //通知生产者
        this.notify();
        //停止生产
        this.flag=true;
    }

}
