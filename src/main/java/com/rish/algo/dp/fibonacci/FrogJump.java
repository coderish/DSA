package com.rish.algo.dp.fibonacci;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] heightArr = {10, 20, 30, 10};
        int[] dp = new int[heightArr.length];
        Arrays.fill(dp, -1);
        System.out.println(energyLost(heightArr, heightArr.length - 1, dp));
        System.out.println(Arrays.toString(dp));
        System.out.println(energyLost_2(heightArr, heightArr.length - 1, 0));
    }

    private static int energyLost(int[] heightArr, int index, int[] dp) {
        if (index == 0) {
            dp[0] = 0;
            return dp[0];
        }
        if (dp[index] == -1) {
            int e1 = energyLost(heightArr, index - 1, dp) + Math.abs(heightArr[index] - heightArr[index - 1]);
            dp[index] = e1;
            if (index > 1) {
                int e2 = energyLost(heightArr, index - 2, dp) + Math.abs(heightArr[index] - heightArr[index - 2]);
                dp[index] = Math.min(e1, e2);
                return dp[index];
            }
        }
        return dp[index];
    }

    // Not truly TailRecursion because the values will be compared in min function
    private static int energyLost_2(int[] arr, int index, int totalEnergyLost) {
        if (index == 0) return totalEnergyLost;

        int e1 = energyLost_2(arr, index - 1, totalEnergyLost + Math.abs(arr[index - 1] - arr[index]));
        if (index > 1) {
            int e2 = energyLost_2(arr, index - 2, totalEnergyLost + Math.abs(arr[index - 2] - arr[index]));
            return Math.min(e1, e2);
        }
        return e1;
    }
}
