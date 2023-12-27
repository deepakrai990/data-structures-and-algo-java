package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q1_Longest_Common_Subsequence_generate_2 {
    // Function to generate the longest common subsequence
    private static String generateLCS(String S1, String S2) {
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
        // Reconstruct the longest common subsequence using the tabulation 2D array
        return reconstructLCS(S1, S2, dp);
    }
    // Helper function to reconstruct the longest common subsequence
    private static String reconstructLCS(String S1, String S2, int[][] dp) {
        int i = S1.length();
        int j = S2.length();
        StringBuilder lcs = new StringBuilder();
        // Traverse the tabulation 2D array to reconstruct the LCS
        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                // Include the matching character in the LCS
                lcs.insert(0, S1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move to the cell with a larger value in the tabulation 2D array
                i--;
            } else {
                j--;
            }
        }
        return lcs.toString();
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        String lcs = generateLCS(S1, S2);

        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
