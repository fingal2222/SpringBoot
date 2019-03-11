package com.example.springboothelloworld.Service.ThreadDemo.concurrent;

public class Test01 implements Runnable  {

    private  int count=0;

    @Override
    public /*synchronized*/ void run() {

        System.out.println(Thread.currentThread().getName()+
        " count="+count++);
    }

    public static void main(String[] args) {
        Test01 test01=new Test01();
        for (int i=0;i<5;i++) {
            new Thread(test01,"Thread"+(i+1)).start();
        }
    }
}
