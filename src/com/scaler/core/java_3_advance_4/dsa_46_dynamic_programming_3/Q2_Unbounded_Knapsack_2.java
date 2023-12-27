package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q2_Unbounded_Knapsack_2 {
    /**
     * Unbounded Knapsack Problem:
     * In the unbounded knapsack problem, you are given a set of items, each with a weight w_i
     * and a value v_i. The goal is to maximize the total value that can be obtained by selecting
     * an unlimited number of items, without exceeding a given capacity W.
     * * **/
    private static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a 2D array to store computed results
        int[][] memo = new int[n + 1][capacity + 1];
        // Initialize the array with -1 to indicate uncomputed results
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        // Start the recursion from the given capacity
        return knapsackRecursive(weights, values, capacity, n, memo);
    }
    // Recursive helper function with memoization
    private static int knapsackRecursive(int[] weights, int[] values, int capacity, int itemIndex, int[][] memo) {
        // Base case: Check if capacity is zero or no more items left
        if (capacity == 0 || itemIndex == 0) {
            return 0;
        }
        // Check if the result is already computed
        if (memo[itemIndex][capacity] != -1) {
            return memo[itemIndex][capacity];
        }
        int maxVal = 0;
        // Explore the solution space by considering each item
        for (int i = 0; i < itemIndex; i++) {
            // If the current item can fit in the knapsack
            if (weights[i] <= capacity) {
                // Recursively call the function with reduced capacity
                int currentVal = values[i] + knapsackRecursive(weights, values, capacity - weights[i],
                        itemIndex, memo);
                // Update the maximum value
                maxVal = Math.max(maxVal, currentVal);
            }
        }
        // Store the computed result in the memoization array
        memo[itemIndex][capacity] = maxVal;
        return maxVal;
    }

    public static void main(String[] args) {
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int capacity = 15;

        int maxValue = unboundedKnapsack(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
