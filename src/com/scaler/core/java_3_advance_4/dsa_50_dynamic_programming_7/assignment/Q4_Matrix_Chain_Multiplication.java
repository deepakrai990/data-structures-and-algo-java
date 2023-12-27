package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 8:48 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Matrix_Chain_Multiplication {
    private int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minCost(A, 1, n - 1, dp);
    }

    // recursion + DP
    private int minCost(int[] A, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], minCost(A, i, k, dp) + minCost(A, k + 1, j, dp) + (A[i - 1] * A[k] * A[j]));
        }
        return dp[i][j];
    }

    private int solve_1(int[] A) {
        return tabulation_mcm(A);
    }

    private int tabulation_mcm(int[] A) {
        int n = A.length;
        // initialize dp array with max value as we need to find the min value
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        // start from bottom row to top row
        for (int i = n; i >= 1; i--) {
            // start from left column to right column
            for (int j = i; j < n; j++) {
                // base case
                if (i == j)
                    dp[i][j] = 0;
                // recursive relation converted to iterative code
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + (A[i - 1] * A[k] * A[j]));
                }
            }
        }
        // answer will be stored at dp[1][n-1]
        return dp[1][n - 1];
    }
}
