package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 22/12/23
 * @project scaler_course_code
 */
public class Q1_Find_minimum_iterations_to_multiply_all_matrices_2 {
    private static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1; // Number of matrices
        int[][] dp = new int[n + 1][n + 1]; // Memoization table
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Call the recursive helper function with memoization
        return matrixChainOrderRecursive(dimensions, 1, n, dp);
    }

    private static int matrixChainOrderRecursive(int[] dimensions, int i, int j, int[][] dp) {
        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Base case: If there is only one matrix, no multiplication is needed
        if (i == j) {
            return 0;
        }
        // Initialize the result to a large value
        int result = Integer.MAX_VALUE;
        // Find the optimal placement for parentheses to minimize the cost
        for (int k = i; k < j; k++) {
            int cost = matrixChainOrderRecursive(dimensions, i, k, dp) +
                    matrixChainOrderRecursive(dimensions, k + 1, j, dp) +
                    dimensions[i - 1] * dimensions[k] * dimensions[j];
            // Update the result if the current placement is more efficient
            result = Math.min(result, cost);
        }
        // Memoize the result and return
        dp[i][j] = result;

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] dimensions = {3, 2, 6, 4, 8}; // {10, 30, 5, 60};
        int minIterations = matrixChainOrder(dimensions);

        System.out.println("Minimum iterations to multiply all matrices: " + minIterations);
    }
}
