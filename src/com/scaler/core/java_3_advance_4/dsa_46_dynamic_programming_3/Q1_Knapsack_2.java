package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q1_Knapsack_2 {
    private static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a memoization array to store computed results
        int[][] memo = new int[n][capacity + 1];
        // Initialize the memoization array with -1 to indicate uncomputed results
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        // Start the recursion from the maximum item index and the maximum capacity
        return knapsackRecursive(n - 1, weights, values, capacity, memo);
    }

    // Recursive helper function with memoization
    private static int knapsackRecursive(int i, int[] weights, int[] values, int capacity, int[][] memo) {
        // Base case: Check if out of bounds or capacity is zero
        if (i < 0 || capacity == 0) {
            return 0;
        }
        // Check if a result is already computed
        if (memo[i][capacity] != -1) {
            return memo[i][capacity];
        }
        // If the current item cannot fit, exclude it
        if (weights[i] > capacity) {
            int result = knapsackRecursive(i - 1, weights, values, capacity, memo);
            memo[i][capacity] = result;
            return result;
        }
        // Choose the maximum value between including and excluding the current item
        int included = values[i] + knapsackRecursive(i - 1, weights, values, capacity - weights[i], memo);
        int excluded = knapsackRecursive(i - 1, weights, values, capacity, memo);
        int result = Math.max(included, excluded);
        // Store the computed result in the memoization array
        memo[i][capacity] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int capacity = 15;

        int maxValue = knapsack(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
