package com.example.springboothelloworld.controller;

import com.example.springboothelloworld.dto.Dog;
import com.example.springboothelloworld.dto.Person;
import com.example.springboothelloworld.utils.HttpUtil;
import com.example.springboothelloworld.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @Autowired
    private  Person person;

    @Autowired
    private JwtUtil  jwtUtil;

    @Autowired
    private HttpUtil httpUtil;


    @Value("${person.lastName}")
    private  String lasName;

    @GetMapping("/hello")
    public  String hello()
    {
        return "Hello World!"+lasName;
    }
    @GetMapping("/{name}")
    /**
     * 请求方式http://127.0.0.1:8081/api/hello/zhangsan?age=18
     */
    public String sayHello(@PathVariable("name") String name, @RequestParam(value = "age") int age)
    {
        return  "hello, my name is  "+name+", an I am "+age+" old;";
    }

    @PostMapping
    public  String requestbody (@RequestBody Dog dog)
    {
        return  person.getLastName()+dog.getName();
    }

    @GetMapping("/token")
    public  String  generateToken(@RequestParam("userName") String userName)
    {
        return jwtUtil.generateToken(userName);
    }
    @GetMapping("/token/validate")
    public  Boolean  validateToken(@RequestParam("token") String token)
    {
        String userName="zhangsan";
        return jwtUtil.validateToken(token,userName);
    }

    @PostMapping("/httpclient")
    public  String httpclient(@RequestParam("token") String token,@RequestParam("url") String url) throws  Exception  {
        Map<String,Object> maps=new HashMap<>();
        maps.put("uuids","44444,33333");
        maps.put("content","for test");
        return httpUtil.request(token,url,maps);
    }
}
