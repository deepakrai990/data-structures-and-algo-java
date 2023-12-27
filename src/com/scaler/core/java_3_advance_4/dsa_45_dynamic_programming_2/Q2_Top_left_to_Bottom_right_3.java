package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q2_Top_left_to_Bottom_right_3 {
    /**
     * Problem: No of ways to go from changing TL (Top Left) (0,0) to fixed BR (Bottom right) (n - i, m - 1) cells
     * using only two directional movements right (->) and down.
     * Using dynamic programming Tabulation
     * **/
    // Function to calculate the number of ways to traverse a grid from changing TL to fixed BR using tabulation
    private static int countWays(int n, int m, int i) {
        // Create a 2D array to store the number of ways for each cell
        int[][] dp = new int[n][m];
        // Initialize the number of ways for the top-left corner
        dp[0][0] = 1;
        // Fill the table iteratively
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // If not in the first row, add ways from the cell above
                if (row > 0) {
                    dp[row][col] += dp[row - 1][col];
                }
                // If not in the first column, add ways from the cell to the left
                if (col > 0) {
                    dp[row][col] += dp[row][col - 1];
                }
            }
        }
        // The result is stored in the specified cell (n - i, m - 1)
        return dp[n - i][m - 1];
    }

    public static void main(String[] args) {
        int n = 4; // Replace with the desired number of rows
        int m = 5; // Replace with the desired number of columns
        int i = 1; // Replace with the desired changing top-left corner parameter
        int ways = countWays(n, m, i);
        System.out.println("Number of ways to traverse the grid: " + ways);
    }
}
