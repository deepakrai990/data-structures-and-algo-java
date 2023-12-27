package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q7_Check_if_we_can_divide_all_elements_into_part_2_or_part_2 {
    /**
     * Problem: Given array A[N] elements.
     * Check if we can divide all elements into part one or part two such that both parts have equaled sum.
     * **/
    // Function to check if array elements can be divided into two parts with equal sum
    private static boolean canPartition(int[] A) {
        // Calculate the total sum of array elements
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }
        // If the total sum is odd, it cannot be divided into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        // Create a memoization table to store computed results
        Boolean[][] dp = new Boolean[A.length + 1][totalSum / 2 + 1];
        // Call the recursive helper function
        return canPartitionRecursive(A, A.length, totalSum / 2, dp);
    }
    // Recursive helper function with memoization
    private static boolean canPartitionRecursive(int[] A, int i, int remainingSum, Boolean[][] dp) {
        // Base cases
        if (remainingSum == 0) {
            return true; // Equal sum found
        }
        if (i == 0 || remainingSum < 0) {
            return false; // Unable to achieve equal sum
        }
        // Check if the result is already computed
        if (dp[i][remainingSum] != null) {
            return dp[i][remainingSum];
        }
        // Include the current element in the first part
        boolean include = canPartitionRecursive(A, i - 1, remainingSum - A[i - 1], dp);
        // Exclude the current element from the first part
        boolean exclude = canPartitionRecursive(A, i - 1, remainingSum, dp);
        // Update the memoization table
        dp[i][remainingSum] = include || exclude;
        return dp[i][remainingSum];
    }
    public static void main(String[] args) {
        int[] A = {3, 5, 2, 100, 90};

        if (canPartition(A)) {
            System.out.println("Array elements can be divided into two parts with equal sum.");
        } else {
            System.out.println("Array elements cannot be divided into two parts with equal sum.");
        }
    }
}
