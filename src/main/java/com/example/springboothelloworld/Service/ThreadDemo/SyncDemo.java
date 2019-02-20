package com.example.springboothelloworld.Service.ThreadDemo;

public class SyncDemo {
    public  static  void  main(String[] args)
    {
        Object money=new Object();
        Object goods=new Object();
        Test test=new Test(money,goods);
        Test2 test2=new Test2(money,goods);
        Thread t1=new Thread(test);
        Thread t2=new Thread(test2);
        t1.start();
        t2.start();
    }
}

class Test implements Runnable {
    Object money;
    Object good;

    public Test() {
    }

    public Test(Object money, Object good) {
        this.money = money;
        this.good = good;
    }

    public void test() {
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (good) {

            }
        }
        System.out.println("一手给钱！");
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }
}

class Test2 implements Runnable {
    Object money;
    Object good;

    public Test2() {
    }

    public Test2(Object money, Object good) {
        this.money = money;
        this.good = good;
    }

    public void test() {
        synchronized (good) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money) {

            }
        }
        System.out.println("一手给货！");
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }
}