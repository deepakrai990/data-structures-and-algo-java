package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q4_Dungeon_Prince_and_Princess_2 {
    /**
     * Code: Tabulation
     * **/
    private static int calculateMinimumHealth(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // Create a 2D array to store the minimum health required
        int[][] dp = new int[m][n];
        // Calculate the minimum health required starting from the bottom-right cell
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        // Calculate the minimum health required in the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        // Calculate the minimum health required in the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        // Calculate the minimum health required for each remaining cell
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }
        // The result is stored in the top-left cell
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
                {-3, 2, 4, -7},
                {-6, 5, -4, 6},
                {-15, -8, 3, -4},
                {7, 4, -2, -7},
        };

        int minInitialHealth = calculateMinimumHealth(dungeon);

        System.out.println("Minimum initial health required: " + minInitialHealth);
    }
}
