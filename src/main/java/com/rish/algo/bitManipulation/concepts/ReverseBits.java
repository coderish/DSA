package com.rish.algo.bitManipulation.concepts;

import java.util.Arrays;

public class ReverseBits {
    public static void main(String[] args) {
        int num = 75;
        System.out.println(num);
        int index = 0;
        byte[] reversedArr = new byte[32];
        int reversedNum = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                reversedArr[31 - index] = 1;
                reversedNum = reversedNum | 1 << (32 - (index + 1));
            } else {
                reversedArr[31 - index] = 0;
            }
            num = num >> 1;
            index++;
        }
        System.out.println(Arrays.toString(reversedArr));
        System.out.println(reversedNum);
    }
}
