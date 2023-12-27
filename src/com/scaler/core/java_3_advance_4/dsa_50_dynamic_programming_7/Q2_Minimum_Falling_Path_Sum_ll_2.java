package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q2_Minimum_Falling_Path_Sum_ll_2 {
    // Function to find the minimum sum
    private static int minSumNoAdjacent(int[][] matrix, int n) {
        int[][] dp = new int[n][n]; // Tabulation table
        // Copy the first row from the matrix to the dp table
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        // Iterate through each row starting from the second row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = Integer.MAX_VALUE;
                // Iterate through all columns in the previous row
                for (int k = 0; k < n; k++) {
                    // Ensure no two elements chosen in adjacent rows are in the same column
                    if (j != k) {
                        minPrev = Math.min(minPrev, dp[i - 1][k]);
                    }
                }
                // Update the dp table with the minimum sum for the current position
                dp[i][j] = matrix[i][j] + minPrev;
            }
        }
        // Find the minimum sum from the last row of the dp table
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 7, 3},
                {5, 1, 4},
                {6, 8, 2}
        };
        int n = 3; // Size of the matrix
        int minSum = minSumNoAdjacent(matrix, n);

        System.out.println("Minimum sum: " + minSum);
    }
}
