package com.rish.algo.dp;

public class DPUtil {
    /*public static <T> T[][] init(int m, int sum, T value) {
//        T[][] dp = new T[m + 1][sum + 1];
        List<T[]> dpList = new LinkedList<>();
        for (int i = 1; i < m + 1; i++) {
            List<T> localList = new LinkedList<>();
            for (int j = 1; j < sum + 1; j++) {
//                dp[i][j] = value;
                localList.add(value);
            }
            dpList.add(localList.);
        }
//        return dp;
        return dpList;
    }*/

    public static int[][] initInt(int m, int sum) {
        int[][] dp = new int[m + 1][sum + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    public static Boolean[][] initBool(int m, int sum) {
        Boolean[][] dp = new Boolean[m + 1][sum + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = null;
            }
        }
        return dp;
    }
}
