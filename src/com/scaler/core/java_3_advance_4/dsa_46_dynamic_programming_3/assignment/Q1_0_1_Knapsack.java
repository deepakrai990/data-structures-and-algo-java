package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.assignment;

/**
 * @created 02/04/23 10:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_0_1_Knapsack {
    //top down
    Integer dp[][] = new Integer[1000][1000];

    private int solve(int[] A, int[] B, int C) {
        int n = A.length;
        return findMaxSum(0, A, B, C);
    }

    private int findMaxSum(int index, int[] values, int[] weights, int remainingCapacity) {
        if (index == values.length || remainingCapacity <= 0)
            return 0;

        if (dp[index][remainingCapacity] != null)
            return dp[index][remainingCapacity];

        int notSelected = findMaxSum(index + 1, values, weights, remainingCapacity);
        //for selection the weight should be less than remainingCapacity
        int selected;
        if (weights[index] > remainingCapacity) {
            selected = findMaxSum(index + 1, values, weights, remainingCapacity);
        } else {
            selected = values[index] + findMaxSum(index + 1, values, weights, remainingCapacity - weights[index]);
        }

        dp[index][remainingCapacity] = Math.max(selected, notSelected);
        return dp[index][remainingCapacity];
    }

    //bottom up
    private int solve_1(int[] A, int[] B, int C) {
        int n = A.length;
        int dp[][] = new int[n + 1][C + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                if (B[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], A[i - 1] + dp[i - 1][j - B[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][C];
    }
}
