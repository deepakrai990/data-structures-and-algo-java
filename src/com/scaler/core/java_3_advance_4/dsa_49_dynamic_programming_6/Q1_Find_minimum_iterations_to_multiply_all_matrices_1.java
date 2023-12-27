package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Find_minimum_iterations_to_multiply_all_matrices_1 {
    /**
     * Problem: Given N matrices find min iteration to multiply all matrices?
     * **/
    static int[][] DP;
    private static int solve(int[] dimensions) {
        int n = dimensions.length - 1; // Number of matrices
        DP = new int[n + 1][n + 1]; // Memoization table
        // Initialize the memoization table with -1 to indicate uncomputed results
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        // Call the recursive helper function with memoization
        return minCostOfMultiply(dimensions, 1, n);
    }
    private static int minCostOfMultiply(int[] dimensions, int i, int j) {
        if (i == j) {
            return 0; // Single matrix cost to multiply is 0
        }
        if (DP[i][j] == -1) {
            // Initialize the result to a large value
            int result = Integer.MAX_VALUE;
            // Find the optimal placement for parentheses to minimize the cost
            for (int k = i; k < j; k++) {
                int cost = minCostOfMultiply(dimensions, i, k) +
                        minCostOfMultiply(dimensions, k + 1, j) +
                        dimensions[i - 1] * dimensions[k] * dimensions[j];
                // Update the result if the current placement is more efficient
                result = Math.min(result, cost);
            }
            DP[i][j] = result;
        }
        return DP[i][j];
    }

    public static void main(String[] args) {
        int[] dimensions = {3, 2, 6, 4, 8}; // {10, 30, 5, 60};
        int result = solve(dimensions);
        PrintUtils.print(result);
        System.out.println("Minimum iterations to multiply all matrices: " + result);
    }
}
