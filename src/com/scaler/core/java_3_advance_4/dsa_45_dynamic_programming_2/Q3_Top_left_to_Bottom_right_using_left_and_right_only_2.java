package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q3_Top_left_to_Bottom_right_using_left_and_right_only_2 {
    /**
     * Code: Memoization
     * **/
    // Function to calculate the number of ways to traverse a grid from TL to BR using only right and left movements with memoization
    private static int countWays(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // Create a memoization array to store computed results
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Start the recursion from the top-left corner
        return countWaysRecursive(n - 1, m - 1, mat, dp);
    }
    // Recursive helper function with memoization using array DP
    private static int countWaysRecursive(int i, int j, int[][] mat, int[][] dp) {
        // Base case: If out of bounds or cell is blocked, return 0
        if (i < 0 || j < 0 || mat[i][j] == 0) {
            return 0;
        }
        // Base case: If at the top-left corner, return 1 way
        if (i == 0 && j == 0) {
            return 1;
        }
        // If the result is already computed, return the memoized value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Calculate the number of ways by considering the two possible directions
        int ways = countWaysRecursive(i - 1, j, mat, dp) + countWaysRecursive(i, j - 1, mat, dp);
        // Store the computed result in the memoization array
        dp[i][j] = ways;
        return ways;
    }
    /**
     * Code: Tabulation
     * **/
    // Function to calculate the number of ways to traverse a grid from TL to BR using only right and left movements with tabulation
    private static int countWays_1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // Create a 2D array to store the number of ways for each cell
        int[][] dp = new int[n][m];
        // Initialize the number of ways for the top-left corner
        dp[0][0] = (mat[0][0] == 1) ? 1 : 0;
        // Fill the table iteratively
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Skip blocked cells
                if (mat[i][j] == 0) {
                    continue;
                }
                // If not in the first row, add ways from the cell above
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                // If not in the first column, add ways from the cell to the left
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        // The result is stored in the bottom-right corner
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int ways = countWays(mat);
        System.out.println("Number of ways to traverse the grid: " + ways);
        int[][] mat1 = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };
        ways = countWays(mat1);
        System.out.println("Number of ways to traverse the grid: " + ways);

        int[][] mat2 = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };
        ways = countWays_1(mat2);
        System.out.println("Number of ways to traverse the grid: " + ways);
    }
}
