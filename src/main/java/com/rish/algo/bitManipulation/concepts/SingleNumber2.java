package com.rish.algo.bitManipulation.concepts;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 1, 2, 3, 10};
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int noOfOneBits = 0;
            for (int num : arr) {
                int iThMask = (1 << i);
                if ((iThMask & num) != 0) {
                    noOfOneBits++;
                }
            }
            if (noOfOneBits % 3 > 0) {
//                ans += (int) (Math.pow(2, i));
                ans = ans | (1 << i);
            }
        }
        System.out.println(ans);
    }

}