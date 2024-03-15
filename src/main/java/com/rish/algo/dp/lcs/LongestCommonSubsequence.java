package com.rish.algo.dp.lcs;

public class LongestCommonSubsequence {

    static int METHOD_CALL_COUNT = 0;

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "xadf";
        System.out.println(longestCommonSubsequence(s1, s2, s1.length() - 1, s2.length() - 1));
        System.out.println("longestCommonSubsequence called for " + METHOD_CALL_COUNT + " times");

        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        System.out.println("\n\n\n");
        METHOD_CALL_COUNT = 0;
        System.out.println(longestCommonSubsequenceMemoized(s1, s2, s1.length() - 1, s2.length() - 1, dp));
        System.out.println("longestCommonSubsequenceMemoized called for " + METHOD_CALL_COUNT + " times");
    }

    /**
     * Recursion
     */
    private static int longestCommonSubsequence(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex) {
        METHOD_CALL_COUNT++;
        if (s1CurrentIndex < 0 || s2CurrentIndex < 0) {
            return 0;
        }
        if (s1.charAt(s1CurrentIndex) == s2.charAt(s2CurrentIndex)) {
            return 1 + longestCommonSubsequence(s1, s2, s1CurrentIndex - 1, s2CurrentIndex - 1);
        } else {
            return Math.max(longestCommonSubsequence(s1, s2, s1CurrentIndex - 1, s2CurrentIndex),
                    longestCommonSubsequence(s1, s2, s1CurrentIndex, s2CurrentIndex - 1));
        }
    }

    /**
     * DP - Top-Down
     */
    private static int longestCommonSubsequenceMemoized(String s1, String s2, int m, int n, int[][] dp) {
        METHOD_CALL_COUNT++;
        if (m == 0 || n == 0) {
            dp[0][0] = 0;
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            if (dp[m][n] == 0) {
                dp[m][n] = longestCommonSubsequenceMemoized(s1, s2, m - 1, n - 1, dp);
            }
            return 1 + dp[m - 1][n - 1];

        } else {
            if (dp[m][n] == 0) {
                dp[m][n] = Math.max(longestCommonSubsequenceMemoized(s1, s2, m - 1, n, dp),
                        longestCommonSubsequenceMemoized(s1, s2, m, n - 1, dp));
            }
            return dp[m][n];
        }
    }
}
