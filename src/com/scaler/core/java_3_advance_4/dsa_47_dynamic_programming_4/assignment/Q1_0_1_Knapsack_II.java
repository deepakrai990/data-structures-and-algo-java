package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.assignment;

/**
 * @created 02/04/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_0_1_Knapsack_II {
    private static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[2][C + 1];

        //mod by 2 will help us to take prev values
        for (int l = 1; l <= n; l++) {
            for (int c = 1; c <= C; c++) {
                if (c >= B[l - 1]) {
                    dp[l % 2][c] = Math.max(dp[(l - 1) % 2][c], dp[(l - 1) % 2][c - B[l - 1]] + A[l - 1]);
                } else
                    dp[l % 2][c] = dp[(l - 1) % 2][c];

            }
        }
        return dp[n % 2][C];
    }
}
