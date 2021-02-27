package com.spring.in.depth.mastering.bean;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public String getName() {
        System.out.println("wow i can call another method in the same class in constructor");
        return "Eayd best";
    }
    public Test() {
        getName();
    }

    public static void main(String[] args) {

        Date d8 = new Date();
        Calendar cal8 = Calendar.getInstance(); // creates calendar
        cal8.setTime(d8); // sets calendar time/date
//        cal8.add(Calendar.DAY_OF_MONTH,1); // adds one
        cal8.add(Calendar.HOUR_OF_DAY,1); //adds one hour
        cal8.add(Calendar.MINUTE,20); //adds one hour
        d8 = cal8.getTime(); // returns new date
        System.out.println(d8);



        new Test();
    }
}
