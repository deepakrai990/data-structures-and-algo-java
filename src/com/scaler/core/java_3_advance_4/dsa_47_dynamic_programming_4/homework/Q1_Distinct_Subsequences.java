package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.homework;

/**
 * @created 02/04/23 10:12 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Distinct_Subsequences {
    Integer dp[][];

    private int numDistinct(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp = new Integer[n + 1][m + 1];
        return findMaxWays(n - 1, m - 1, A, B);
    }

    private int findMaxWays(int i, int j, String A, String B) {
        //whole B string matched with A
        if (j < 0)
            return 1;
        //String B did not matched with A
        if (i < 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];
        //if characters matched I can either consider that element or do not consider
        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = findMaxWays(i - 1, j - 1, A, B) + findMaxWays(i - 1, j, A, B);
        } else {
            dp[i][j] = findMaxWays(i - 1, j, A, B); // do not consider only one option
        }
        return dp[i][j];
    }

    private int numDistinct_1(String A, String B) {
        int n = A.length();
        int m = B.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
