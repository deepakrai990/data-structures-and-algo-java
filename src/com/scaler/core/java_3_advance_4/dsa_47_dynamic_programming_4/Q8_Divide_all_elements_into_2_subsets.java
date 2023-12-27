package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q8_Divide_all_elements_into_2_subsets {
    /**
     * Problem: Given array A[N] elements.
     * Divide all into two subsets.
     * Divide in such a way that difference between both is minimum.
     * **/
    // Function to find the minimum subset sum difference
    private static int minSubsetSumDifference(int[] A) {
        // Calculate the total sum of array elements
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }
        // Create a memoization table to store computed results
        int[][] dp = new int[A.length + 1][totalSum + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // Call the recursive helper function
        return minSubsetSumDifferenceRecursive(A, A.length, 0, totalSum, dp);
    }
    // Recursive helper function with memoization
    private static int minSubsetSumDifferenceRecursive(int[] A, int i, int subsetSum, int totalSum, int[][] dp) {
        // Base case
        if (i == 0) {
            return Math.abs(totalSum - 2 * subsetSum);
        }
        // Check if the result is already computed
        if (dp[i][subsetSum] != -1) {
            return dp[i][subsetSum];
        }
        // Include the current element in the subset
        int include = minSubsetSumDifferenceRecursive(A, i - 1, subsetSum + A[i - 1], totalSum, dp);
        // Exclude the current element from the subset
        int exclude = minSubsetSumDifferenceRecursive(A, i - 1, subsetSum, totalSum, dp);
        // Update the memoization table
        dp[i][subsetSum] = Math.min(include, exclude);
        return dp[i][subsetSum];
    }
    public static void main(String[] args) {
        int[] A = {3, 2, 4, 7, 6, 3};

        int minDifference = minSubsetSumDifference(A);

        System.out.println("Minimum subset sum difference: " + minDifference);
    }
}
