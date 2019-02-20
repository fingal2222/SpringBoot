package com.example.springboothelloworld.Service.ThreadDemo.ProdAndCons;

public class Player implements Runnable {
    private Movie m;

    public Player(Movie m) {
        super();
        this.m = m;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            if (0==i%2)
            {
//                System.out.println("i=="+i);
                m.play("左青龙");
            }
            else
            {
//                System.out.println("i2=="+i);
                m.play("右白虎");
            }
        }
    }
}
