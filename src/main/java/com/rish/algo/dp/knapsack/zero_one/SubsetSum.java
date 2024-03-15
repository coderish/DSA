package com.rish.algo.dp.knapsack.zero_one;

import com.rish.algo.dp.DPUtil;

public class SubsetSum {
    static int METHOD_CALLED_COUNTER = 0;

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int sum = 13;

        System.out.println(subsetSum(nums, nums.length, sum));
        System.out.println("subsetSum was called for " + METHOD_CALLED_COUNTER + " times\n\n");
        METHOD_CALLED_COUNTER = 0;

        sum = 22;
        System.out.println(subsetSumMemoized(nums, nums.length, sum, DPUtil.initBool(nums.length, sum)));
        System.out.println("subsetSumMemoized was called for " + METHOD_CALLED_COUNTER + " times\n\n");
        METHOD_CALLED_COUNTER = 0;

        sum = 21;
        System.out.println(subsetSumIterative_BottomUp(nums, sum));
        System.out.println("subsetSumIterative_BottomUp was called for " + METHOD_CALLED_COUNTER + " times");
        METHOD_CALLED_COUNTER = 0;
    }

    private static boolean subsetSum(int[] nums, int size, int targetSum) {
        METHOD_CALLED_COUNTER++;
        if (targetSum < 0) return false;
        if (size == 0) {
            return targetSum == 0;
        }
        return subsetSum(nums, size - 1, targetSum - nums[size - 1]) || subsetSum(nums, size - 1, targetSum);
    }

    private static boolean subsetSumMemoized(int[] nums, int size, int targetSum, Boolean[][] dp) {
        METHOD_CALLED_COUNTER++;
//        if (targetSum < 0) return false;
        if (size == 0) {
            dp[size][targetSum] = targetSum == 0;
            return dp[size][targetSum];
        }
        /*if (dp[size][targetSum] == null) {
            dp[size][targetSum] = subsetSumMemoized(nums, size - 1, targetSum - nums[size - 1], dp) ||
                    subsetSumMemoized(nums, size - 1, targetSum, dp);
        }*/
        if (dp[size][targetSum] == null) {
            if (targetSum >= nums[size - 1]) {
                dp[size][targetSum] = subsetSumMemoized(nums, size - 1, targetSum - nums[size - 1], dp) ||
                        subsetSumMemoized(nums, size - 1, targetSum, dp);
            } else {
                dp[size][targetSum] = subsetSumMemoized(nums, size - 1, targetSum, dp);
            }
        }
        return dp[size][targetSum];
    }

    private static boolean subsetSumIterative_BottomUp(int[] nums, int targetSum) {
        Boolean[][] dp = DPUtil.initBool(nums.length, targetSum);
        for (int i = 1; i < targetSum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int m = 1; m < nums.length + 1; m++) {
            for (int n = 1; n < targetSum + 1; n++) {
                if (dp[m][n] == null) {
                    if (n >= nums[m - 1]) {
                        dp[m][n] = dp[m - 1][n - nums[m - 1]] || dp[m - 1][n];
                    } else {
                        dp[m][n] = dp[m - 1][n];
                    }
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}
