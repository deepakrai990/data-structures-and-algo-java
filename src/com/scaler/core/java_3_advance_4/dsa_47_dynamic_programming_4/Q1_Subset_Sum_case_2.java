package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q1_Subset_Sum_case_2 {
    // Function to check if there exists a subset with sum equals to K
    private static boolean isSubsetSum(int[] A, int N, int K) {
        // Create a memoization table to store computed results
        int[][] dp = new int[N + 1][K + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // Start the recursion from the first element and the target sum K
        return subsetSumRecursive(A, N, K, dp);
    }
    // Recursive helper function with memoization
    private static boolean subsetSumRecursive(int[] A, int i, int remainingSum, int[][] dp) {
        // Base cases
        if (remainingSum == 0) {
            return true; // Subset with sum K exists
        }
        if (i == 0 || remainingSum < 0) {
            return false; // Subset with sum K does not exist
        }
        // Check if result is already computed
        if (dp[i][remainingSum] != -1) {
            return dp[i][remainingSum] == 1;
        }
        // Include the current element in the subset
        boolean include = subsetSumRecursive(A, i - 1, remainingSum - A[i - 1], dp);
        // Exclude the current element from the subset
        boolean exclude = subsetSumRecursive(A, i - 1, remainingSum, dp);
        // Update the memoization table
        dp[i][remainingSum] = (include || exclude) ? 1 : 0;
        return include || exclude;
    }
    public static void main(String[] args) {
        int[] A = {7, 4, 9, 6, 10, 13, 14, 11};
        int N = A.length;
        int K = 26;

        boolean existsSubset = isSubsetSum(A, N, K);

        if (existsSubset) {
            System.out.println("Subset with sum " + K + " exists.");
        } else {
            System.out.println("Subset with sum " + K + " does not exist.");
        }
    }
}
