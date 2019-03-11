package com.example.springboothelloworld.Service.ThreadDemo.concurrent;

import javax.management.relation.RoleUnresolved;

public class Test02 {
    public synchronized void m1(String name) {
        System.out.println("public synchromize void m1() start "+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("m1() end");
    }

    public synchronized void m2() {
        System.out.println("public synchromize void m2() start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("m2() end");
    }

    public void m3() {
        System.out.println("public synchromize void m3() start");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("m3() end");
    }

    public static class Thread02 implements Runnable {
        int i;
        Test02 t2;

        public Thread02(int i, Test02 test02) {
            this.t2 = test02;
            this.i = i;
        }

        @Override
        public void run() {
            if (i == 0) {
                t2.m1("0");
            } else if (i < 0) {
                t2.m1("-1");
            } else t2.m3();
        }
    }

    public static void main(String[] args) {
        Test02 t2=new Test02();
        new Thread(new Test02.Thread02(0,t2)).start();
        new Thread(new Test02.Thread02(-1,t2)).start();
        new Thread(new Test02.Thread02(2,t2)).start();
        new Thread(new Test02.Thread02(3,t2)).start();
    }
}
