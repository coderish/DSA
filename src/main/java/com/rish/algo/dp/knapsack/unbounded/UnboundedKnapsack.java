package com.rish.algo.dp.knapsack.unbounded;

import com.rish.algo.dp.DPUtil;

public class UnboundedKnapsack {
    static int GLOBAL_METHOD_CALLED_COUNTER = 0;

    public static void main(String[] args) {
        int maxWeight = 8;
        int[] weightArray = {1, 3, 4, 5};
        int[] valueArray = {10, 40, 50, 70};

        /*int maxWeight = 10;
        int[] weightArray = {2, 4, 6};
        int[] valueArray = {5, 11, 13};*/

        System.out.println(unboundedKnapsack(weightArray, valueArray, weightArray.length, maxWeight));
        System.out.println("unboundedKnapsack called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;

        System.out.println(unboundedKnapsackMemoized(weightArray, valueArray, weightArray.length, maxWeight, DPUtil.initInt(weightArray.length, maxWeight)));
        System.out.println("unboundedKnapsackMemoized called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;

        System.out.println(unboundedKnapsackBottomUpDP(weightArray, valueArray, weightArray.length, maxWeight));
        System.out.println("unboundedKnapsackBottomUpDP called for " + GLOBAL_METHOD_CALLED_COUNTER + " times\n\n");
        GLOBAL_METHOD_CALLED_COUNTER = 0;
    }

    private static int unboundedKnapsack(int[] weightArray, int[] valueArray, int size, int currentWeight) {
        GLOBAL_METHOD_CALLED_COUNTER++;
        if (size == 0 || currentWeight == 0) {
            return 0;
        }
        if (currentWeight >= weightArray[size - 1]) {
            return Math.max(valueArray[size - 1] + unboundedKnapsack(weightArray, valueArray, size, currentWeight - weightArray[size - 1]),
                    unboundedKnapsack(weightArray, valueArray, size - 1, currentWeight));
        } else {
            return unboundedKnapsack(weightArray, valueArray, size - 1, currentWeight);
        }
    }

    private static int unboundedKnapsackMemoized(int[] weightArray, int[] valueArray, int size, int currentWeight, int[][] dp) {
        GLOBAL_METHOD_CALLED_COUNTER++;
        if (size == 0 || currentWeight == 0) {
            return 0;
        }
        if (dp[size][currentWeight] == -1) {
            if (currentWeight >= weightArray[size - 1]) {
                dp[size][currentWeight] = Math.max(
                        valueArray[size - 1] + unboundedKnapsackMemoized(weightArray, valueArray, size, currentWeight - weightArray[size - 1], dp),
                        unboundedKnapsackMemoized(weightArray, valueArray, size - 1, currentWeight, dp));
            } else {
                dp[size][currentWeight] = unboundedKnapsackMemoized(weightArray, valueArray, size - 1, currentWeight, dp);
            }
        }
        return dp[size][currentWeight];
    }

    private static int unboundedKnapsackBottomUpDP(int[] weightArray, int[] valueArray, int size, int maxWeight) {
        int[][] dp = DPUtil.initInt(size, maxWeight);
        for (int m = 1; m < size + 1; m++) {
            for (int n = 1; n < maxWeight + 1; n++) {
                if (n >= weightArray[m - 1]) {
                    dp[m][n] = Math.max(valueArray[m - 1] + dp[m][n - weightArray[m - 1]], dp[m - 1][n]);
                } else {
                    dp[m][n] = dp[m - 1][n];
                }
            }
        }
        return dp[size][maxWeight];
    }

}
