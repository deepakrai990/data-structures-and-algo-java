package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 18/12/23
 * @project scaler_course_code
 */
public class Q4_Dungeon_Prince_and_Princess_3 {
    /**
     * Code: Memoization
     * **/
    private static int calculateMinimumHealth(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // Create a memoization array to store computed results
        int[][] memo = new int[m][n];
        // Initialize a memoization array with -1 to indicate uncomputed results
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // Start the recursion from the top-left cell
        return calculateMinimumHealthRecursive(0, 0, dungeon, memo);
    }
    // Recursive helper function with memoization
    private static int calculateMinimumHealthRecursive(int i, int j, int[][] dungeon, int[][] memo) {
        // Base case: Check if out of bounds
        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MAX_VALUE; // Infinity, indicating an invalid path
        }
        // Check if a result is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // Calculate the minimum health required by considering the current cell and moving to the right or down
        int rightHealth = calculateMinimumHealthRecursive(i, j + 1, dungeon, memo);
        int downHealth = calculateMinimumHealthRecursive(i + 1, j, dungeon, memo);
        // Choose the minimum health required to survive
        int minHealthRequired = Math.min(rightHealth, downHealth);
        // Calculate the health required to enter the current cell
        int healthRequired = (minHealthRequired == Integer.MAX_VALUE) ? 1 : minHealthRequired;
        healthRequired -= dungeon[i][j];
        // Ensure that healthRequired is at least 1
        memo[i][j] = Math.max(1, healthRequired);
        return memo[i][j];
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
