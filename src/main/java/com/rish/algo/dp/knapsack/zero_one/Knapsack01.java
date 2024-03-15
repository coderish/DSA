package com.rish.algo.dp.knapsack.zero_one;

import com.rish.algo.dp.DPUtil;

public class Knapsack01 {
    // Given int[] weight, int[] profit and a knapsack of capacity W. Find the max profit that can be arranged in the knapsack.
    static int GLOBAL_METHOD_CALLED_COUNTER = 0;

    public static void main(String[] args) {
        int[] weight = {1, 3, 5, 4, 7};
        int[] profit = {8, 2, 6, 1, 3};
        int MAX_CAPACITY = 10;

        System.out.println(knapsack01(weight, profit, weight.length - 1, MAX_CAPACITY));
        System.out.println("knapsack01 was called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;

        System.out.println(knapsack01Memoized(weight, profit, weight.length, MAX_CAPACITY, DPUtil.initInt(weight.length, MAX_CAPACITY)));
        System.out.println("knapsack01Memoized was called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;

        System.out.println(knapsack01BottomUpDP(weight, profit, weight.length, MAX_CAPACITY));
        System.out.println("knapsack01BottomUpDP was called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;
    }

    private static int knapsack01(int[] weight, int[] profit, int size, int currentCapacity) {
        GLOBAL_METHOD_CALLED_COUNTER++;
        if (size < 0) {
            return 0;
        }
        if (weight[size] <= currentCapacity) {
            return Math.max(profit[size] + knapsack01(weight, profit, size - 1, currentCapacity - weight[size]),
                    knapsack01(weight, profit, size - 1, currentCapacity));
        }
        return knapsack01(weight, profit, size - 1, currentCapacity);
    }

    private static int knapsack01Memoized(int[] weight, int[] profit, int size, int currentCapacity, int[][] dp) {
        GLOBAL_METHOD_CALLED_COUNTER++;
        /**
         * Not required because index 0 has been taken care during array initialization
         * if (size == 0 || currentCapacity == 0) {
         *   dp[size][currentCapacity] = 0;
         * }
         **/
        if (dp[size][currentCapacity] == -1) {
            if (weight[size - 1] <= currentCapacity) {
                dp[size][currentCapacity] = Math.max(profit[size - 1] + knapsack01Memoized(weight, profit, size - 1, currentCapacity - weight[size - 1], dp),
                        knapsack01Memoized(weight, profit, size - 1, currentCapacity, dp));
            } else dp[size][currentCapacity] = knapsack01Memoized(weight, profit, size - 1, currentCapacity, dp);
        }
        return dp[size][currentCapacity];
    }

    private static int knapsack01BottomUpDP(int[] weight, int[] profit, int arrSize, int maxCapacity) {
        int[][] dp = new int[weight.length + 1][maxCapacity + 1];
        for (int size = 1; size < arrSize + 1; size++) {
            for (int currentCapacity = 1; currentCapacity < maxCapacity + 1; currentCapacity++) {
                if (weight[size - 1] <= currentCapacity) {
                    dp[size][currentCapacity] = Math.max(profit[size - 1] + dp[size - 1][currentCapacity - weight[size - 1]], dp[size - 1][currentCapacity]);
                } else dp[size][currentCapacity] = dp[size - 1][currentCapacity];
            }
        }
        return dp[weight.length][maxCapacity];
    }

}
