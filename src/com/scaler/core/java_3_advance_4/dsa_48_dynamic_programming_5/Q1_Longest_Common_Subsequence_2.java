package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q1_Longest_Common_Subsequence_2 {
    // Function to find the length of the longest common subsequence
    private static int longestCommonSubsequence(String S1, String S2) {
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
        return lcsRecursive(S1, S2, N, M, dp);
    }

    // Recursive helper function with memoization
    private static int lcsRecursive(String S1, String S2, int i, int j, int[][] dp) {
        // Base case
        if (i == 0 || j == 0) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If the characters match, include them in the common subsequence
        if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            int result = 1 + lcsRecursive(S1, S2, i - 1, j - 1, dp);
            dp[i][j] = result;
            return result;
        } else {
            // Characters do not match, explore both possibilities
            int result = Math.max(
                    lcsRecursive(S1, S2, i - 1, j, dp),
                    lcsRecursive(S1, S2, i, j - 1, dp)
            );

            // Update the memoization 2D array
            dp[i][j] = result;
            return result;
        }
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        int length = longestCommonSubsequence(S1, S2);

        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
