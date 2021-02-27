package com.spring.in.depth.mastering.bean;

public class Test {

    public String getName() {
        System.out.println("wow i can call another method in the same class in constructor");
        return "Eayd best";
    }
    public Test() {
        getName();
    }

    public static void main(String[] args) {
        new Test();
    }
}
