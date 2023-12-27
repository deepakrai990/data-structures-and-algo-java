package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q1_Knapsack_4 {
    private static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a 2D array to store computed results
        int[][] dp = new int[n + 1][capacity + 1];
        // Fill the table iteratively from left to right
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                // Base case: No items or zero capacity
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    // If the current item cannot fit, exclude it
                    if (weights[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // Choose the maximum value between including and excluding the current item
                        dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                    }
                }
            }
        }
        // The result is stored in the bottom-right cell of the table
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int capacity = 15;

        int maxValue = knapsack(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
