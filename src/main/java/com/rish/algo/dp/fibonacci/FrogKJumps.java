package com.rish.algo.dp.fibonacci;

public class FrogKJumps {
    static int K = 2;

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(findELost(arr, arr.length - 1));
    }

    private static int findELost(int[] arr, int index) {
        if (index == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= K; j++) {
            if (index >= j) {
                ans = Math.min(ans, findELost(arr, index - j) + Math.abs(arr[index] - arr[index - j]));
            }
        }
        return ans;
    }

}
