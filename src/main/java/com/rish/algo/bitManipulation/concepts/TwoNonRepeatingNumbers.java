package com.rish.algo.bitManipulation.concepts;

public class TwoNonRepeatingNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 6};
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        int xorMsb = xor & -xor;
        int group1Xor = 0, group2Xor = 0;

        for (int num : arr) {
            if ((num & xorMsb) == 0) {
                group1Xor ^= num;
            } else {
                group2Xor ^= num;
            }
        }
        System.out.println(group1Xor + ", " + group2Xor);
    }
}
