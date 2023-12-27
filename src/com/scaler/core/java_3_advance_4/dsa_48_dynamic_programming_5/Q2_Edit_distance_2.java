package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q2_Edit_distance_2 {
    // Function to find the minimum operations
    private static int minOperations(String S1, String S2) {
        int N = S1.length();
        int M = S2.length();
        // Create a memoization 2D array to store computed results
        int[][] dp = new int[N + 1][M + 1];
        // Initialize the memoization 2D array with -1 to indicate uncomputed results
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        // Start the recursion from the end of both strings
        return editDistanceRecursive(S1, S2, N, M, dp);
    }
    // Recursive helper function with memoization
    private static int editDistanceRecursive(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // If the characters match, move to the next characters
        if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            int result = editDistanceRecursive(S1, S2, i - 1, j - 1, dp);
            dp[i][j] = result;
            return result;
        } else {
            // Explore all possibilities and find the minimum
            int insert = 1 + editDistanceRecursive(S1, S2, i, j - 1, dp);
            int delete = 1 + editDistanceRecursive(S1, S2, i - 1, j, dp);
            int replace = 1 + editDistanceRecursive(S1, S2, i - 1, j - 1, dp);
            int result = Math.min(Math.min(insert, delete), replace);
            // Update the memoization 2D array
            dp[i][j] = result;
            return result;
        }
    }
    public static void main(String[] args) {
        String S1 = "dfael";
        String S2 = "fgl";

        int operations = minOperations(S1, S2);

        System.out.println("Minimum Operations: " + operations);
    }
}
