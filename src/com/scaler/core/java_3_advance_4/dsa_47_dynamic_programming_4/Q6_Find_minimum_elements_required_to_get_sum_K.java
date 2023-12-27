package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q6_Find_minimum_elements_required_to_get_sum_K {
    /**
     * Problem: Given array A[N] elements.
     * Find minimum elements required to get sum equals to K. all elements are positive.
     * Note: Every element can be picked zero time or any number of times.
     * **/
    // Function to find the minimum number of elements required to get sum equals to K
    private static int minElementsToSum(int[] A, int K) {
        // Create a memoization table to store computed results
        int[][] dp = new int[A.length + 1][K + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // Call the recursive helper function
        return minElementsRecursive(A, A.length, K, dp);
    }
    // Recursive helper function with memoization
    private static int minElementsRecursive(int[] A, int i, int remainingSum, int[][] dp) {
        // Base cases
        if (remainingSum == 0) {
            return 0; // No elements needed
        }
        if (i == 0 || remainingSum < 0) {
            return Integer.MAX_VALUE; // Invalid case, return a large value
        }
        // Check if result is already computed
        if (dp[i][remainingSum] != -1) {
            return dp[i][remainingSum];
        }
        // Include the current element in the sum
        int include = 1 + minElementsRecursive(A, i, remainingSum - A[i - 1], dp);
        // Exclude the current element from the sum
        int exclude = minElementsRecursive(A, i - 1, remainingSum, dp);
        // Update the memoization table
        dp[i][remainingSum] = Math.min(include, exclude);
        return dp[i][remainingSum];
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 5};
        int K = 7;

        int minElements = minElementsToSum(A, K);

        if (minElements == Integer.MAX_VALUE) {
            System.out.println("No subset found with sum " + K);
        } else {
            System.out.println("Minimum elements required to get sum " + K + ": " + minElements);
        }
    }
}
