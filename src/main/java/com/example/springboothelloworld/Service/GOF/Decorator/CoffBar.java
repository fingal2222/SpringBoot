package com.example.springboothelloworld.Service.GOF.Decorator;

public class CoffBar {
    public static void main(String[] args) {
        Drink order;
        order=new Decaff();
        System.out.println("order 1 desc "+order.getDescription());
        System.out.println("order1 price"+order.getPrice());
        order=new Milk(order);

        System.out.println("order 2 desc "+order.getDescription());
        System.out.println("order2 price"+order.getPrice());
    }
}
