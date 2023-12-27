package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q2_Minimum_Falling_Path_Sum_ll_1 {
    /**
     * Problem: Minimum Falling Path Sum - II
     * Given N * N matrix, find the minimum sum we can get such that
     *      a. In very row, we should pick one element.
     *      B. No two elements chosen in adjacent rows cannot be in the same column
     * **/
    private static int[][] DP;
    private static int solve(int[][] matrix, int N) {
        DP = new int[N][N];
        for (int[] row: DP) {
            Arrays.fill(row, - 1);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.min(result, matrix[0][i] + minSumRecursive(matrix, N, 1, i));
        }
        return result;
    }
    private static int minSumRecursive(int[][] matrix, int n, int row, int prevCol) {
        // Base case: if we have reached the last row
        if (row == n) {
            return 0;
        }
        // Check if the result is already computed
        if (DP[row][prevCol] != -1) {
            return DP[row][prevCol];
        }
        int result = Integer.MAX_VALUE;
        // Iterate through all columns in the current row
        for (int j = 0; j < n; j++) {
            // Ensure no two elements chosen in adjacent rows are in the same column
            if (j != prevCol) {
                result = Math.min(result, matrix[row][j] + minSumRecursive(matrix, n, row + 1, j));
            }
        }
        // Save the computed result in the memoization table
        DP[row][prevCol] = result;
        return DP[row][prevCol];
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 4, 5, 6},
                {3, 2, 2, 7},
                {4, 3, 7, 5},
                {2, 7, 6, 2},
        };
        int result = solve(matrix, matrix.length);
        PrintUtils.print(result);
        System.out.println("Minimum sum: " + result);
    }
}
