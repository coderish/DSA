package com.rish.algo.bitManipulation;

public class BitOperations {
    public static void main(String[] args) {
        BitOperations bOps = new BitOperations();
        System.out.println(bOps.multiply2ByTimes(11));
        System.out.println(bOps.checkRightmostSetBit(110));
        System.out.println(bOps.removeRightmostSetBit(10));
    }

    private int multiply2ByTimes(int num) {
        return 1 << num;
    }

    private int checkRightmostSetBit(int num) {
        return (num & -num);
    }

    private int removeRightmostSetBit(int num) {
        return num - (num & -num);
    }
}
