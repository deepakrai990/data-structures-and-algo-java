package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.assignment;

/**
 * @created 02/04/23 10:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Unbounded_Knapsack {
    private static int solve(int A, int[] B, int[] C) {
        int n = B.length;
        //B = values
        int[][] dp = new int[n + 1][A + 1];

        //Setting first row and col to zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= A; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= A; j++) {
                //Not pick a item
                dp[i][j] = dp[i - 1][j];
                //pick a iteam
                if (j - C[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], B[i - 1] + dp[i][j - C[i - 1]]);
                }
            }
        }
        return dp[n][A];
    }
}
