package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q5_Number_of_subsets_with_sum_equals_to_K {
    /**
     * Problem: Given array A[N] elements.
     * Find number of subsets with the sum equals to K, all elements are positive.
     * Note: Every element can be picked zero time or any number of times.
     * **/
    // Function to find the number of subsets with sum equals to K
    private static int countSubsetsWithSum(int[] A, int N, int K) {
        // Create a memoization table to store computed results
        int[][] dp = new int[N + 1][K + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // Start the recursion from the first element and the target sum K
        return subsetCountRecursive(A, N, K, dp);
    }
    // Recursive helper function with memoization
    private static int subsetCountRecursive(int[] A, int i, int remainingSum, int[][] dp) {
        // Base cases
        if (remainingSum == 0) {
            return 1; // Subset with sum K exists, count it
        }
        if (i == 0 || remainingSum < 0) {
            return 0; // Subset with sum K does not exist
        }
        // Check if the result is already computed
        if (dp[i][remainingSum] != -1) {
            return dp[i][remainingSum];
        }
        // Include the current element in the subset
        int include = subsetCountRecursive(A, i, remainingSum - A[i - 1], dp);
        // Exclude the current element from the subset
        int exclude = subsetCountRecursive(A, i - 1, remainingSum, dp);
        // Update the memoization table
        dp[i][remainingSum] = include + exclude;
        return dp[i][remainingSum];
    }
    public static void main(String[] args) {
        int[] A = {7, 4, 9, 6, 10, 13, 14, 11};
        int N = A.length;
        int K = 26;

        int numSubsets = countSubsetsWithSum(A, N, K);

        System.out.println("Number of subsets with sum " + K + ": " + numSubsets);
    }
}
