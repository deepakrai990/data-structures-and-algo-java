package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q2_Unbounded_Knapsack_1 {
    /**
     * Unbounded Knapsack Problem:
     * In the unbounded knapsack problem, you are given a set of items, each with a weight w_i
     * and a value v_i. The goal is to maximize the total value that can be obtained by selecting
     * an unlimited number of items, without exceeding a given capacity W.
     * * **/
    private static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a 2D array to store computed results
        int[][] dp = new int[n + 1][capacity + 1];
        // Initialize the array with zeros
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        // Fill the array iteratively
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                // If the current item can fit in the knapsack
                if (weights[i - 1] <= j) {
                    // Update the maximum value for the current capacity
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i][j - weights[i - 1]]);
                } else {
                    // If the current item cannot fit, use the value from the previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // The result is stored in the last cell of the array
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int capacity = 15;

        int maxValue = unboundedKnapsack(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
