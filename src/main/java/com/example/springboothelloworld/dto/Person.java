package com.example.springboothelloworld.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@PropertySource("application-dev.yml")
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String lastName;
    private int age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private List<Object> arrays;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public Date getBirth() {
        return birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public List<Object> getArrays() {
        return arrays;
    }

    public Dog getDog() {
        return dog;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public void setArrays(List<Object> arrays) {
        this.arrays = arrays;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
