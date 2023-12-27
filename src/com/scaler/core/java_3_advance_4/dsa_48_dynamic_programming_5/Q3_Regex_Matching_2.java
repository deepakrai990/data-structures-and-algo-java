package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

/**
 * @author Deepak Kumar Rai
 * @created 21/12/23
 * @project scaler_course_code
 */
public class Q3_Regex_Matching_2 {
    // Function to check if the text matches the pattern
    private static boolean isMatch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        // Create a memoization 2D array to store computed results
        int[][] dp = new int[m + 1][n + 1];
        // Initialize the memoization 2D array with -1 to indicate uncomputed results
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        // Start the recursion from the end of both text and pattern
        return isMatchRecursive(text, pattern, m, n, dp) == 1;
    }
    // Recursive helper function with memoization
    private static int isMatchRecursive(String text, String pattern, int i, int j, int[][] dp) {
        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Base case: both text and pattern are empty, so they match
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
            return 1;
        }

        // Base case: a pattern is empty, but a text is not, so they don't match
        if (j == 0) {
            dp[i][j] = 0;
            return 0;
        }
        // Base case: a text is empty, but a pattern is not
        if (i == 0) {
            // Check if the pattern has '*' and can be skipped
            if (pattern.charAt(j - 1) == '*') {
                int result = isMatchRecursive(text, pattern, i, j - 2, dp);
                dp[i][j] = result;
                return result;
            } else {
                dp[i][j] = 0;
                return 0;
            }
        }
        char textChar = text.charAt(i - 1);
        char patternChar = pattern.charAt(j - 1);
        // Case 1: Characters match or pattern has '?'
        if (textChar == patternChar || patternChar == '?') {
            int result = isMatchRecursive(text, pattern, i - 1, j - 1, dp);
            dp[i][j] = result;
            return result;
        }
        // Case 2: Pattern has '*'
        if (patternChar == '*') {
            // '*' matches zero characters in the text or one character in the text
            int result = (isMatchRecursive(text, pattern, i, j - 2, dp) == 1) ||
                    (isMatchRecursive(text, pattern, i - 1, j, dp) == 1) ? 1 : 0;

            dp[i][j] = result;
            return result;
        }
        // Characters don't match
        dp[i][j] = 0;
        return 0;
    }
    public static void main(String[] args) {
        String text = "acdcb";
        String pattern = "a*c?b";

        boolean result = isMatch(text, pattern);

        System.out.println("Text and Pattern Match: " + result);
    }
}
