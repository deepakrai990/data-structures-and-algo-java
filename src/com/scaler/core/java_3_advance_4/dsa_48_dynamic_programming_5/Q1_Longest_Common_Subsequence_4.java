package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q1_Longest_Common_Subsequence_4 {
    /**
     * Code: Tabulation
     * **/
    // Function to find the length of the longest common subsequence
    private static int longestCommonSubsequence(String S1, String S2) {
        int N = S1.length();
        int M = S2.length();

        // Create a tabulation 2D array to store computed results
        int[][] dp = new int[N + 1][M + 1];

        // Fill the tabulation 2D array bottom-up
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The result is stored in the bottom-right cell of the tabulation 2D array
        return dp[N][M];
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        int length = longestCommonSubsequence(S1, S2);

        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
