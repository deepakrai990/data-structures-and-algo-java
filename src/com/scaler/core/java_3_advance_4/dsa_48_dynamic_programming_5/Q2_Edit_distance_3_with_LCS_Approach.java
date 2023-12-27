package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 21/12/23
 * @project scaler_course_code
 */
public class Q2_Edit_distance_3_with_LCS_Approach {
    // Function to find the minimum operations using LCS approach
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
        return N + M - 2 * lcs(S1, S2, N, M, dp);
    }

    // Function to find the length of the Longest Common Subsequence
    private static int lcs(String S1, String S2, int i, int j, int[][] dp) {
        // Base case
        if (i == 0 || j == 0) {
            return 0;
        }
        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // If the characters match, include them in the LCS
        if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            int result = 1 + lcs(S1, S2, i - 1, j - 1, dp);
            dp[i][j] = result;
            return result;
        } else {
            // Characters do not match, explore both possibilities
            int result = Math.max(
                    lcs(S1, S2, i - 1, j, dp),
                    lcs(S1, S2, i, j - 1, dp)
            );
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
