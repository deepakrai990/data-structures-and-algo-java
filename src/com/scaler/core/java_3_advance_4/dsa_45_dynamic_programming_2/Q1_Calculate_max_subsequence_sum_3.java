package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Calculate_max_subsequence_sum_3 {
    /**
     * Code: Tabulation
     * **/
    // Function to calculate the maximum subsequence sum using dynamic programming tabulation
    private static int maxSubsequenceSum(int[] A) {
        int N = A.length;
        // Create a table to store the maximum subsequence sum ending at each position
        int[] dp = new int[N];
        // Base case: The maximum subsequence sum ending at the first position is the element itself
        dp[0] = A[0];
        // Calculate the maximum subsequence sum for each position
        for (int i = 1; i < N; i++) {
            // The maximum subsequence sum ending at position i is the maximum of the current element
            // and the sum of the maximum subsequence sum ending at the previous position and the current element
            dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
        }
        // Find the maximum value in the table, which represents the overall maximum subsequence sum
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
    private static int maxSubsequenceSum_1(int[] A) {
        // Initialize the base case
        int[] dp = new int[A.length];
        dp[0] = A[0];
        // Iterate through the array
        for (int i = 1; i < A.length; i++) {
            // Choose the maximum of the current element or the previous sum + the current element
            dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
        }
        // Return the maximum subsequence sum
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args) {
        int[] A = {2, -1, -4, 5, 3, -1, 4, 2};
        int result = maxSubsequenceSum(A);
        System.out.println("Maximum subsequence sum: " + result);
        result = maxSubsequenceSum_1(A);
        System.out.println("Maximum subsequence sum: " + result);
    }
}
