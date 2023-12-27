package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 21/12/23
 * @project scaler_course_code
 */
public class Q3_Regex_Matching_4 {
    static int[][] dp;
    private static boolean isMatch(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        // Create a memoization 2D array to store computed results
        dp = new int[N + 1][M + 1];
        // Initialize the memoization 2D array with -1 to indicate uncomputed results
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // Start the recursion from the end of both text and pattern
        return isMatchRecursive(text, pattern, N, M) == 1;
    }
    private static int isMatchRecursive(String text, String pattern, int i, int j) {
        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Base case: both text and pattern are empty, so they match
        if (j == 0) {
            dp[i][j] = (i == 0) ? 1 : 0;
            return dp[i][j];
        }
        // Base case: a pattern is empty, but a text is not, so they don't match
        if (i == 0) {
            // Check if the pattern has '*' and can be skipped using a for loop
            for (int k = 0; k < j; k++) {
                if (pattern.charAt(k) != '*') {
                    dp[i][j] = 0;
                    return 0;
                }
            }
            dp[i][j] = 1;
            return 1;
        }
        char textChar = text.charAt(i - 1);
        char patternChar = pattern.charAt(j - 1);
        // Case 1: Characters match or pattern has '?'
        if (textChar == patternChar || patternChar == '?') {
            int result = isMatchRecursive(text, pattern, i - 1, j - 1);
            dp[i][j] = result;
            return result;
        }
        // Case 2: Pattern has '*'
        if (patternChar == '*') {
            // '*' matches zero characters in the text or one character in the text
            int result = isMatchRecursive(text, pattern, i, j - 1) | isMatchRecursive(text, pattern, i - 1, j);
            dp[i][j] = result;
            return result;
        }
        // Characters don't match
        dp[i][j] = 0;
        return 0;
    }
    public static void main(String[] args) {
        String s = "ant";
        String p = "a?**t";

        boolean result = isMatch(s, p);

        System.out.println("String and Pattern Match: " + result);
    }
}
