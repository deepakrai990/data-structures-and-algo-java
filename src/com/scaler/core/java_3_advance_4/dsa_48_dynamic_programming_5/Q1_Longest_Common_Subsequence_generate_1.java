package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q1_Longest_Common_Subsequence_generate_1 {
    // Function to generate the longest common subsequence
    private static String generateLCS(String S1, String S2) {
        int N = S1.length();
        int M = S2.length();
        // Create a memoization 2D array to store computed results
        String[][] dp = new String[N + 1][M + 1];
        // Initialize the memoization 2D array with empty strings
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = "";
            }
        }
        // Start the recursion from the end of both strings
        return lcsRecursive(S1, S2, N, M, dp);
    }
    // Recursive helper function with memoization
    private static String lcsRecursive(String S1, String S2, int i, int j, String[][] dp) {
        // Base case
        if (i == 0 || j == 0) {
            return "";
        }
        // Check if the result is already computed
        if (!dp[i][j].isEmpty()) {
            return dp[i][j];
        }
        // If the characters match, include them in the common subsequence
        if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            String result = lcsRecursive(S1, S2, i - 1, j - 1, dp) + S1.charAt(i - 1);
            dp[i][j] = result;
            return result;
        } else {
            // Characters do not match, explore both possibilities
            String result1 = lcsRecursive(S1, S2, i - 1, j, dp);
            String result2 = lcsRecursive(S1, S2, i, j - 1, dp);
            // Update the memoization 2D array with the longer result
            dp[i][j] = (result1.length() > result2.length()) ? result1 : result2;
            return dp[i][j];
        }
    }
    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        String lcs = generateLCS(S1, S2);

        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
