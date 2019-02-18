package com.example.springboothelloworld;

import com.example.springboothelloworld.Service.yieldDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootHelloworldApplication.class)
public class SpringbootHelloworldApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("hello");

    }
    @Test
    public  void  testThread()        throws  InterruptedException{
        yieldDemo ms = new yieldDemo();
        Thread t1 = new Thread(ms,"张三吃完还剩");
        Thread t2 = new Thread(ms,"李四吃完还剩");
        Thread t3 = new Thread(ms,"王五吃完还剩");
        t1.start();
        t1.join();

        t2.start();
        t3.start();
        System.out.println( "主线程");

    }

}

