package com.example.springboothelloworld.controller;

import com.example.springboothelloworld.Service.yieldDemo;
import com.example.springboothelloworld.dto.Consumer;
import com.example.springboothelloworld.dto.Dog;
import com.example.springboothelloworld.dto.Person;
import com.example.springboothelloworld.dto.Producer;
import com.example.springboothelloworld.utils.HttpUtil;
import com.example.springboothelloworld.utils.JwtUtil;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @Autowired
    private Person person;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private HttpUtil httpUtil;


    @Value("${person.lastName}")
    private String lasName;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!" + lasName;
    }

    @GetMapping("/{name}")
    /**
     * 请求方式http://127.0.0.1:8081/api/hello/zhangsan?age=18
     */
    public String sayHello(@PathVariable("name") String name, @RequestParam(value = "age") int age) {
        return "hello, my name is  " + name + ", an I am " + age + " old;";
    }

    @PostMapping
    public String requestbody(@RequestBody Dog dog) {
        return person.getLastName() + dog.getName();
    }

    @GetMapping("/token")
    public String generateToken(@RequestParam("userName") String userName) {
        return jwtUtil.generateToken(userName);
    }

    @GetMapping("/token/validate")
    public Boolean validateToken(@RequestParam("token") String token) {
        String userName = "zhangsan";
        return jwtUtil.validateToken(token, userName);
    }

    @PostMapping("/httpclient")
    public String httpclient(@RequestParam("token") String token, @RequestParam("url") String url) throws Exception {
        Map<String, Object> maps = new HashMap<>();
        maps.put("uuids", "44444,33333");
        maps.put("content", "for test");
        return httpUtil.request(token, url, maps);
    }

    @GetMapping("/test")
    public void ttt() {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);

        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }

    @GetMapping("/yieldDemo")
    public void yieldDemo() throws InterruptedException {
        yieldDemo ms = new yieldDemo();
        Thread t1 = new Thread(ms, "张三吃完还剩");
        Thread t2 = new Thread(ms, "李四吃完还剩");
        Thread t3 = new Thread(ms, "王五吃完还剩");
        long start = System.currentTimeMillis();
        t1.start();
        t1.join(100);
        System.out.println(System.currentTimeMillis() - start);
        t2.start();
        t3.start();
        System.out.println("主线程");
    }

    @GetMapping("/yieldDemo1/{total}")
    public void testsfor(@PathVariable("total") int total) {
//L是压力表，先都未0；
        int Max = 6;
        DenseMatrix64F stress = new DenseMatrix64F(12, 4); //初始化一个矩阵，并进行下面的赋值
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {

                stress.set(i, j, 0);
            }
        }
        DenseMatrix64F stressTmp =stress.copy();
        List<String> office = Arrays.asList("A", "B", "C", "D");

        //假设有5个学生
        for (int num = 0; num < total; num++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("A", 2);
            map.put("B", 2);
            map.put("C", 4);
            map.put("D", 4);

            DenseMatrix64F L2 = new DenseMatrix64F(12, 4); //初始化一个矩阵，并进行下面的赋值
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {
                    L2.set(i, j, 0);
                }
            }
            int tmp = 0;
            int k;
            for (int i = 0; i < 4; i++) {
                int a = map.get(office.get(i));
                for (k = tmp; k < a + tmp; k++) {
                    L2.set(k, i, 1);
                }
                tmp += a;
            }

            CommonOps.add(stressTmp, L2, stressTmp);

//            System.out.println("data为:");
//            System.out.println(stressTmp);
            //如果超过限制换行
            List<Integer> all= new ArrayList<Integer>();
            all.add(0);
            all.add(1);
            all.add(2);
            all.add(3);
           int excessCol=0;
           int blankCol=0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((int) stressTmp.get(i, j) > 6) {
                        excessCol=j;//超过限制的列
                        //找一个距离最近的空列进行交换
                        for (int m=excessCol+1;m<4;m++) {
                            if ((int) stressTmp.get(i, m)< 6) {
                                blankCol = m;
                                j=4;
                                break;
                            }
                        }
                        List<Integer> exclued=new ArrayList<Integer>();
                        exclued.add(blankCol);
                        exclued.add(excessCol);
                        L2=change(L2,blankCol,excessCol);

                        all.removeAll(exclued);
                        L2=change(L2,(int)all.get(0),(int)all.get(1));
                    }
                }
                i=12;
            }
            CommonOps.add(stress, L2, stress);
            stressTmp=stress.copy();
            int stu=num+1;
            System.out.println("第"+stu+"个学生的分配情况：");
            System.out.println(L2);
        }
        System.out.println("stress:"+stress);
    }


    public DenseMatrix64F change(DenseMatrix64F denseMatrix64F, int i, int j) {

        int numRows = denseMatrix64F.getNumRows();
        for (int k=0;k<numRows;k++)
        {
            double tmp=denseMatrix64F.get(k,i);
            double tmp2=denseMatrix64F.get(k,j);
            denseMatrix64F.set(k,i,tmp2);
            denseMatrix64F.set(k,j,tmp);
        }
        return denseMatrix64F;
    }
}
