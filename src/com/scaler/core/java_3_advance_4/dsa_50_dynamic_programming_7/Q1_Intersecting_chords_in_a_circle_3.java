package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q1_Intersecting_chords_in_a_circle_3 {
    private static int[][] DP;
    public static int countIntersectingChords(int n) {
        // Create a memoization 2D array to store computed results
        DP = new int[n + 1][n + 1];
        // Initialize the memoization 2D array with -1 to indicate uncomputed results
        for (int[] row: DP) {
            Arrays.fill(row, - 1);
        }
        return countChordsRecursive(n);
    }
    private static int countChordsRecursive(int n) {
        // Check if the result is already computed
        if (DP[n][n] != -1) {
            return DP[n][n];
        }
        // Base case: no chords left to draw
        if (n == 0) {
            DP[n][n] = 1;
            return 1;
        }
        int result = 0;
        // Iterate over all possible ways to draw the first chord
        for (int i = 0; i < n; i++) {
            // Recursively calculate the number of ways to draw chords for the remaining points
            result += countChordsRecursive(i) * countChordsRecursive(n - i - 1);
        }
        // Update the memoization table
        DP[n][n] = result;
        return result;
    }
    public static void main(String[] args) {
        int n = 5; // Number of pairs of points
        int ways = countIntersectingChords(n);
        System.out.println("Number of ways to draw non-intersecting chords: " + ways);
    }
}
