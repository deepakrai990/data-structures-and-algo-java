package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Longest_Common_Subsequence_1 {
    /**
     * Problem: Given two strings S1 with length N and S2 with length M.
     * Find length of the longest common subsequence.
     * **/
    static int[][] DP;
    private static int solve(String S1, String S2) {
        int N = S1.length();
        int M = S2.length();
        DP = new int[N][M];
        for (int[] row: DP) {
            Arrays.fill(row, -1);
        }
        return lcs(S1, S2, N - 1, M - 1);
    }
    private static int lcs(String S1, String S2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (DP[i][j] == -1) {
            if (S1.charAt(i) == S2.charAt(j)) { // Match found
                DP[i][j] = lcs(S1, S2, i - 1, j - 1) + 1;
            } else {
                DP[i][j] = Math.max(lcs(S1, S2, i - 1, j), lcs(S1, S2, i, j - 1));
            }
        }
        return DP[i][j];
    }
    public static void main(String[] args) {
        String S1 = "abbcdgf";
        String S2 = "bachegf";
        int result = solve(S1, S2);
        PrintUtils.print(result);
    }
}
