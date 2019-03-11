package com.example.springboothelloworld.Service.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         //简单调用
//         MyThread2 myThread2=new MyThread2();
//         FutureTask<String> result=new FutureTask<>(myThread2);
//         Thread thread=new Thread(result);
//         thread.start();
//         try {
//             String str=result.get();
//             System.out.println(str);
//         }
//         catch (Exception ex)
//         {
//             System.out.println(ex.getMessage());
//         }
        //线程池方式

        int taskSize = 5;
        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(taskSize);
        for (int i = 0; i < taskSize; i++) {
            myCallable my = new myCallable(i);
            Future f = (executor).submit(my);
            list.add(f);
        }
        (executor).shutdown();
        for (int i = 0; i < taskSize; i++) {
            System.out.println(list.get(i).get());
        }

    }
}

class MyThread2 implements Callable<String> {
    private int taskSize;

    public MyThread2(int taskSize) {
        this.taskSize = taskSize;
    }

    @Override
    public String call() throws Exception {
//        System.out.println("我是callable实现的方法！");
        return "我是callable实现的方法！";
    }
}

class myCallable implements Callable<String> {
    private int taskSize;

    public myCallable(int taskSize) {
        this.taskSize = taskSize;
    }
    @Override
    public String call() throws Exception {
        return "我是线程池的callable实现的方法！" + taskSize;
    }
}

class myRunnable implements  Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
