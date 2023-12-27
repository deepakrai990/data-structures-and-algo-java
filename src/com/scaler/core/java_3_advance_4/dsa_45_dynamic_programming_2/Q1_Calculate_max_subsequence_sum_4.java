package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Calculate_max_subsequence_sum_4 {
    // Function to calculate the maximum subsequence sum using dynamic programming memoization
    private static int maxSubsequenceSum(int[] A) {
        int N = A.length;
        // Create an array to store computed results (memoization)
        int[] memo = new int[N];
        Arrays.fill(memo, Integer.MIN_VALUE);
        // Start the recursion from the first element
        return maxSubsequenceSumRecursive(A, 0, memo);
    }
    // Recursive helper function with memoization
    private static int maxSubsequenceSumRecursive(int[] A, int i, int[] memo) {
        // Base case: If we have reached the end of the array, return 0
        if (i == A.length) {
            return 0;
        }
        // If the result is already computed, return the memoized value
        if (memo[i] != Integer.MIN_VALUE) {
            return memo[i];
        }
        // Calculate the maximum subsequence sum either by including or excluding the current element
        int includeCurrent = A[i] + maxSubsequenceSumRecursive(A, i + 1, memo);
        int excludeCurrent = maxSubsequenceSumRecursive(A, i + 1, memo);
        // Update the memo table with the computed result
        memo[i] = Math.max(includeCurrent, excludeCurrent);
        return memo[i];
    }

    public static void main(String[] args) {
        int[] A = {2, -1, -4, 5, 3, -1, 4, 2};
        int result = maxSubsequenceSum(A);

        System.out.println("Maximum subsequence sum: " + result);
    }
}
