package com.rish.algo.bitManipulation.concepts;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 4};
        int xorAns = 0;
        for (int num : arr) {
            xorAns ^= num;
        }
        System.out.println(xorAns);
    }
}
