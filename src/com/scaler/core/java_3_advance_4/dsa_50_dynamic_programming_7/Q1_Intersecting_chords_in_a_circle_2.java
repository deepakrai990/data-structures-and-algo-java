package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q1_Intersecting_chords_in_a_circle_2 {
    public static int countIntersectingChords(int n) {
        // Create a memoization array to store computed results
        int[] dp = new int[n + 1];
        // Initialize the memoization array with -1 to indicate uncomputed results
        Arrays.fill(dp, -1);
        return countChordsRecursive(n, dp);
    }
    private static int countChordsRecursive(int n, int[] dp) {
        // Check if the result is already computed
        if (dp[n] != -1) {
            return dp[n];
        }
        // Base case: no chords left to draw
        if (n == 0) {
            dp[n] = 1;
            return 1;
        }
        int result = 0;
        // Iterate over all possible ways to draw the first chord
        for (int i = 0; i < n; i++) {
            // Recursively calculate the number of ways to draw chords for the remaining points
            result += countChordsRecursive(i, dp) * countChordsRecursive(n - i - 1, dp);
        }
        // Update the memoization array
        dp[n] = result;
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 3; // Number of pairs of points
        int ways = countIntersectingChords(n);
        System.out.println("Number of ways to draw non-intersecting chords: " + ways);
    }
}
