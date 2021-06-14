package com.spring.in.depth.mastering.test;

import java.math.BigInteger;

public class Enc {

    public static void main(String[] args) {
        Enc s = new Enc();
        long startTime = System.nanoTime();
        System.out.println(s.solution("011100"));
        System.out.println(s.solution("111"));
        System.out.println(s.solution("1111010101111"));
        System.out.println(s.solution("1"));
        System.out.println("First solution time taken:" + (System.nanoTime() - startTime)/1000 );
        long secondStartTime = System.nanoTime();
        System.out.println(s.solution2("011100"));
        System.out.println(s.solution2("111"));
        System.out.println(s.solution2("1111010101111"));
        System.out.println(s.solution2("1"));
        System.out.println("Second solution time taken:" + (System.nanoTime() - secondStartTime)/1000 );
    }

    public int solution(String s) {
        int firstOneInIndex = s.indexOf("1");
        return firstOneInIndex == -1 ? 0 : s.replace("0", "").length() + s.length() - firstOneInIndex - 1;
    }

    public int solution2(String s) {
        int number = Integer.parseInt(s, 2), counter = 0;
        while (number > 0) {
            counter++;
            number = number % 2 == 0 ? number / 2 : number - 1;
        }
        return counter;
    }
}
