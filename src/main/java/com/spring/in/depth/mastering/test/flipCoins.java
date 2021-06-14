package com.spring.in.depth.mastering.test;

import java.util.Arrays;

public class flipCoins {


    public static int solution(int[] A) {
       return minFlipToToAlternate(A);
    }

    public static int flip(int v)
    {
        return (v == 0) ? 1 : 0;
    }

    public static int getFlipWithStart(int[] A,int expected) {
        int fcou = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != expected)
                fcou++;
            expected = flip(expected);
        }
        return fcou;
    }

    public static int minFlipToToAlternate(int[] A)
    {
        return Math.min(getFlipWithStart(A, 0), getFlipWithStart(A, 1));
    }

    //  Driver code to test above method
    public static void main(String args[])
    {
//        int[] A = {1,0,1,0,1,1};
//        System.out.println(solution(A));

        int[] B = {1, 1, 0, 1, 1};
        System.out.println(solution(B));

    }


}
