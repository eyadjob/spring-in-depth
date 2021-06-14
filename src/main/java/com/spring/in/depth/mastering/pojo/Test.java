package com.spring.in.depth.mastering.pojo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        ; // returns new date
        System.out.println(d8);

        String pattern = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nowDate = "2021-03-07 18:30:38.6793374 +03:00";
        try {
            Date date1 = simpleDateFormat.parse(nowDate);
            Calendar cal9 = Calendar.getInstance(); // creates calendar
            cal9.setTime(date1);
            cal9.add(Calendar.MINUTE,-5);
            date1 = cal9.getTime();
            System.out.println("date after adding 5 minutes: " + simpleDateFormat.format(date1) + ".0000000 +03:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            System.out.println( URLEncoder.encode("2021-03-04T16:57:57z`", StandardCharsets.UTF_8.toString()));;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        new Test();
    }
}
