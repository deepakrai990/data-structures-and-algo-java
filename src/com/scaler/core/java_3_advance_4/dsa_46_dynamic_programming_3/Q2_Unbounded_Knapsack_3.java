package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q2_Unbounded_Knapsack_3 {
    private static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Create a HashMap to store computed results
        Map<String, Integer> memo = new HashMap<>();
        // Start the recursion from the given capacity
        return knapsackRecursive(weights, values, capacity, n, memo);
    }
    // Recursive helper function with memoization
    private static int knapsackRecursive(int[] weights, int[] values, int capacity, int itemIndex, Map<String, Integer> memo) {
        // Base case: Check if capacity is zero or no more items left
        if (capacity == 0 || itemIndex == 0) {
            return 0;
        }
        // Check if the result is already computed
        String key = itemIndex + "-" + capacity;
        if (memo.containsKey(key)) {
            return memo.get(key);
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
        // Store the computed result in the memoization HashMap
        memo.put(key, maxVal);
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
