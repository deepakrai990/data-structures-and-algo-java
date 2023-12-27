package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 22/12/23
 * @project scaler_course_code
 */
public class Q1_Find_minimum_iterations_to_multiply_all_matrices_3 {
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1; // Number of matrices
        int[][] dp = new int[n + 1][n + 1]; // Tabulation table
        // Initialization: Setting the cost of multiplying a single matrix to 0
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        // Filling the table diagonally based on chain length
        for (int chainLength = 2; chainLength <= n; chainLength++) {
            for (int i = 1; i <= n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // Finding the optimal placement for parentheses to minimize the cost
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        // The result is stored in the top-right corner of the table
        return dp[1][n];
    }
    public static void main(String[] args) {
        int[] dimensions = {3, 2, 6, 4, 8};
        int minIterations = matrixChainOrder(dimensions);

        System.out.println("Minimum iterations to multiply all matrices: " + minIterations);
    }
}
