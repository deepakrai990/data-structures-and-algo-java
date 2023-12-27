package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q2_Top_left_to_Bottom_right_2 {
    /**
     * Code: Tabulation
     * **/
    // Function to calculate the number of ways to traverse a grid from TL to BR using tabulation
    private static int countWays(int n, int m) {
        // Create a 2D array to store the number of ways for each cell
        int[][] dp = new int[n][m];
        // Initialize the number of ways for the top-left corner
        dp[0][0] = 1;
        // Fill the table iteratively
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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
        int n = 4; // Replace with the desired number of rows
        int m = 5; // Replace with the desired number of columns

        int ways = countWays(n, m);

        System.out.println("Number of ways to traverse the grid: " + ways);
    }
}
