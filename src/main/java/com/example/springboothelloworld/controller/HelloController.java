package com.example.springboothelloworld.controller;

import com.example.springboothelloworld.Service.yieldDemo;
import com.example.springboothelloworld.dto.Consumer;
import com.example.springboothelloworld.dto.Dog;
import com.example.springboothelloworld.dto.Person;
import com.example.springboothelloworld.dto.Producer;
import com.example.springboothelloworld.utils.HttpUtil;
import com.example.springboothelloworld.utils.JwtUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.json.JSONObject;
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
    private static ArrayList<Integer> tmpArr = new ArrayList<>();

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
        int numMonth=12;
        int numOffice=4;
        int [] com = {1,2,3,4};
        DenseMatrix64F stress = new DenseMatrix64F(numMonth, numOffice); //初始化一个矩阵，并进行下面的赋值
        for (int i = 0; i < numMonth; i++) {
            for (int j = 0; j < numOffice; j++) {

                stress.set(i, j, 0);
            }
        }
        DenseMatrix64F zero=stress.copy();
        DenseMatrix64F stressTmp =stress.copy();
        List<String> office = Arrays.asList("A", "B", "C", "D");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 2);
        map.put("B", 2);
        map.put("C", 4);
        map.put("D", 4);

        //按需求生成优先级矩阵
        DenseMatrix64F init = new DenseMatrix64F(numMonth, numOffice); //初始化一个矩阵，并进行下面的赋值
        for (int i = 0; i < numMonth; i++) {
            for (int j = 0; j < numOffice; j++) {
                init.set(i, j, 0);
            }
        }
        int tmp = 0;
        int k;
        for (int i = numOffice-1; i >=0; i--) {
            int a = map.get(office.get(i));
            for (k = tmp; k < a + tmp; k++) {
                init.set(k, i, 1);
            }
            tmp += a;
        }
        System.out.println("data:");
        System.out.println(init);
        //假设有5个学生
        for (int num = 0; num < total; num++) {
            DenseMatrix64F L2=init.copy();
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
//            for (int i = 0; i < numMonth; i++) {
//                for (int j = 0; j < numOffice; j++) {
//                    if ((int) stressTmp.get(i, j) > Max) {
//                        excessCol=j;//超过限制的列
//                        map.get(office.get(j));//科室时长;
//                        //找一个距离最近的空列进行交换
//                        for (int m=excessCol+1;m<numOffice;m++) {
//                            if ((int) stressTmp.get(i, m)< Max) {
//                                blankCol = m;
//                                j=4;
//                                break;
//                            }
//                        }
//                        List<Integer> exclued=new ArrayList<Integer>();
//                        exclued.add(blankCol);
//                        exclued.add(excessCol);
//                        L2=change(L2,blankCol,excessCol);
//
//                        all.removeAll(exclued);
//                        L2=change(L2,(int)all.get(0),(int)all.get(1));
//                    }
//                }
//                i=12;
//            }

                        for (int i = 0; i < numMonth; i++) {
                            for (int j = 0; j < numOffice; j++) {
                                if ((int) stressTmp.get(i, j) > Max) {

                                    int [] com2 = {1,2,3,4};
                                    String str=arrangement(numOffice,com);
//                                    str.split()
//                                    list.removeAll(all);
//                                    stressTmp=stress;
//                                    DenseMatrix64F dd=shuffle(zero,list);
//                                    CommonOps.add(dd,stressTmp,stressTmp);

                                }
                            }
                        }
            CommonOps.add(stress, L2, stress);
            stressTmp=stress.copy();
            int stu=num+1;
            System.out.println("第"+stu+"个学生的分配情况：");
            System.out.println(L2);
        }
        System.out.println("stress:"+stress);
    }

    @GetMapping("/yieldDemo2/{total}")
    public void testsfor2(@PathVariable("total") int total)
    {

        int [] com = {1,2,3,4};
        int k = 4;
        System.out.println("\n排列结果：");
        arrangement(k,com);
        int Max = 6;
        int numMonth=12;
        int numOffice=4;
        DenseMatrix64F stress = new DenseMatrix64F(numMonth, numOffice); //初始化一个矩阵，并进行下面的赋值
        for (int i = 0; i < numMonth; i++) {
            for (int j = 0; j < numOffice; j++) {

                stress.set(i, j, 0);
            }
        }
        JsonObject jsonObject=new JsonObject();
        JsonArray array=new JsonArray();
        JsonObject jsonObject1=new JsonObject();
        jsonObject1.addProperty("id","A");
        jsonObject1.addProperty("colIndex",0);
        jsonObject1.addProperty("len",2);
        jsonObject1.addProperty("scale","0,2,4,6,8,10");
        array.add(jsonObject1);
        JsonObject jsonObject2=new JsonObject();
        jsonObject2.addProperty("id","B");
        jsonObject2.addProperty("colIndex",1);
        jsonObject2.addProperty("len",2);
        jsonObject2.addProperty("scale","0,2,4,6,8,10");
        array.add(jsonObject2);
        JsonObject jsonObject3=new JsonObject();
        jsonObject3.addProperty("id","C");
        jsonObject3.addProperty("colIndex",2);
        jsonObject3.addProperty("len",4);
        jsonObject3.addProperty("scale","0,4,8");
        array.add(jsonObject3);
        JsonObject jsonObject4=new JsonObject();
        jsonObject4.addProperty("id","D");
        jsonObject4.addProperty("colIndex",3);
        jsonObject4.addProperty("len",4);
        jsonObject4.addProperty("scale","0,4,8");
        array.add(jsonObject4);
        jsonObject.add("properties",array);
        System.out.println(jsonObject.toString());
       JsonArray jsonArray= jsonObject.get("properties").getAsJsonArray();

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

    public String arrangement(int k,int []arr){
        String str="";
        if(k == 1){
            for (int i = 0; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                str=str+","+tmpArr.toString();
                System.out.print(tmpArr.toString() + ",");
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = 0; i < arr.length; i++) { //按顺序挑选一个元素
                tmpArr.add(arr[i]); //添加选到的元素
                arrangement(k - 1, removeArrayElements(arr, tmpArr.toArray(new Integer[1]))); //没有取过的元素，继续挑选
                tmpArr.remove((Object)arr[i]);
            }
        }else{

        }
        return str;
    }

    public static int[] removeArrayElements(int[] arr, Integer... elements){
        List<Integer> remainList = new ArrayList<>(arr.length);
        for(int i=0;i<arr.length;i++){
            boolean find = false;
            for(int j=0;j<elements.length;j++){
                if(arr[i] == elements[j]){
                    find = true;
                    break;
                }
            }
            if(!find){ //没有找到的元素保留下来
                remainList.add(arr[i]);
            }
        }
        int[] remainArray = new int[remainList.size()];
        for(int i=0;i<remainList.size();i++){
            remainArray[i] = remainList.get(i);
        }
        return remainArray;
    }

    public  DenseMatrix64F  shuffle(DenseMatrix64F denseMatrix64F,ArrayList<Integer> tmpArr2 )
    {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 2);
        map.put("B", 2);
        map.put("C", 4);
        map.put("D", 4);
        int tmp=0;
        for (int i=0;i<tmpArr2.size();i++)
        {
            int len=map.get(tmpArr2.get(i));
            for (int j=tmp;j<len+tmp;j++)
            {
                denseMatrix64F.set(j,i,1);
            }
            tmp+=len;
        }
        return  denseMatrix64F;
    }
}
