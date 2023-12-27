package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q1_Knapsack_5 {
    /**
     * Code: Memoization
     * Left to Right
     * **/
    private static int knapsack(int[] weights, int[] values, int capacity) {
        // Create a memoization map to store computed results
        Map<String, Integer> memo = new HashMap<>();
        // Start the recursion from the minimum item index and the minimum capacity
        return knapsackRecursive(0, weights, values, capacity, memo);
    }
    // Recursive helper function with memoization
    private static int knapsackRecursive(int i, int[] weights, int[] values, int capacity, Map<String, Integer> memo) {
        // Base case: Check if out of bounds or capacity is zero
        if (i >= weights.length || capacity == 0) {
            return 0;
        }
        // Check if the result is already computed
        String key = i + "-" + capacity;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // If the current item cannot fit, exclude it
        if (weights[i] > capacity) {
            int result = knapsackRecursive(i + 1, weights, values, capacity, memo);
            memo.put(key, result);
            return result;
        }
        // Choose the maximum value between including and excluding the current item
        int included = values[i] + knapsackRecursive(i + 1, weights, values, capacity - weights[i], memo);
        int excluded = knapsackRecursive(i + 1, weights, values, capacity, memo);
        int result = Math.max(included, excluded);
        // Store the computed result in the memoization map
        memo.put(key, result);
        return result;
    }

    private static int knapsack_1(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a memoization map to store computed results
        Map<String, Integer> memo = new HashMap<>();
        // Start the recursion from the maximum item index and the maximum capacity
        return knapsackRecursive_1(n - 1, weights, values, capacity, memo);
    }
    // Recursive helper function with memoization
    private static int knapsackRecursive_1(int i, int[] weights, int[] values, int capacity, Map<String, Integer> memo) {
        // Base case: Check if out of bounds or capacity is zero
        if (i < 0 || capacity == 0) {
            return 0;
        }
        // Check if the result is already computed
        String key = i + "-" + capacity;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // If the current item cannot fit, exclude it
        if (weights[i] > capacity) {
            int result = knapsackRecursive_1(i - 1, weights, values, capacity, memo);
            memo.put(key, result);
            return result;
        }
        // Choose the maximum value between including and excluding the current item
        int included = values[i] + knapsackRecursive_1(i - 1, weights, values, capacity - weights[i], memo);
        int excluded = knapsackRecursive_1(i - 1, weights, values, capacity, memo);
        int result = Math.max(included, excluded);
        // Store the computed result in the memoization map
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[] weights = {4, 1, 5, 4, 3, 7, 4};
        int[] values = {3, 2, 8, 3, 7, 10, 5};
        int capacity = 15;

        int maxValue = knapsack(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);

        maxValue = knapsack_1(weights, values, capacity);
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
