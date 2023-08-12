package com.rish.algo.dp.fibonacci;

public class ClimbingStairs_DP {
    public static void main(String[] args) {
        int totalSteps = 3;
        System.out.println(findWays(totalSteps));
    }

    private static int findWays(int stepsLeft) {
        if (stepsLeft == 0 || stepsLeft == 1) return 1;
        return findWays(stepsLeft - 1) + findWays(stepsLeft - 2);
    }
}
