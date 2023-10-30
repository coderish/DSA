package com.rish.algo.dp.fibonacci;

import java.util.Arrays;

/**
 * Maximum Sum of Non-Adjacent Elements
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(findMaxSum(arr, arr.length - 1, dp));
    }

    private static int findMaxSum(int[] arr, int index, int[] dp) {
        if (index == 0) {
            dp[0] = arr[0];
            return dp[0];
        }
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        dp[index] = Math.max(
                findMaxSum(arr, index - 1, dp),
                findMaxSum(arr, index - 2, dp) + arr[index]);
        return dp[index];
    }
}
