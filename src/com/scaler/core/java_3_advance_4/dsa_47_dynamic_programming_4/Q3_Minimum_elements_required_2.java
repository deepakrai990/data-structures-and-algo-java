package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q3_Minimum_elements_required_2 {
    // Function to find the minimum number of elements required to get sum equals to K
    private static int minElementsToSum(int[] A, int N, int K) {
        // Create a memoization table to store computed results
        int[][] dp = new int[N + 1][K + 1];
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // Start the recursion from the first element and the target sum K
        return minElementsRecursive(A, N, K, dp);
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
        // Check if the result is already computed
        if (dp[i][remainingSum] != -1) {
            return dp[i][remainingSum];
        }
        // Include the current element in the sum
        int include = 1 + minElementsRecursive(A, i - 1, remainingSum - A[i - 1], dp);
        // Exclude the current element from the sum
        int exclude = minElementsRecursive(A, i - 1, remainingSum, dp);
        // Update the memoization table
        dp[i][remainingSum] = Math.min(include, exclude);
        return dp[i][remainingSum];
    }

    public static void main(String[] args) {
        int[] A = {7, 4, 9, 6, 10, 13, 14, 11};
        int N = A.length;
        int K = 26;

        int minElements = minElementsToSum(A, N, K);

        if (minElements == Integer.MAX_VALUE) {
            System.out.println("No subset found with sum " + K);
        } else {
            System.out.println("Minimum elements required to get sum " + K + ": " + minElements);
        }
    }
}
