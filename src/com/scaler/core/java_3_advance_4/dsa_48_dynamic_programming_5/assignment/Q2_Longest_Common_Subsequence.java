package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 10:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Longest_Common_Subsequence {
    // Bottom-UP
    private int solve(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < dp.length; i++) { //filling the first row of DP.
            if (A.charAt(i) == B.charAt(0)) dp[i][0] = 1;
            else {
                if (i != 0) {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        for (int i = 0; i < dp[0].length; i++) {  //filling the first col of DP.
            if (A.charAt(0) == B.charAt(i)) dp[0][i] = 1;
            else {
                if (i != 0) {
                    dp[0][i] = dp[0][i - 1];
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // Top-Down
    int[][] dp;
    String A;
    String B;

    private int solve_1(String A, String B) {
        dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        this.A = A;
        this.B = B;
        return lcs(A.length() - 1, B.length() - 1);
    }

    private int lcs(int end1, int end2) {
        if (end1 < 0 || end2 < 0) return 0;

        if (dp[end1][end2] != -1) {
            return dp[end1][end2];
        }
        if (A.charAt(end1) == B.charAt(end2)) {
            return 1 + lcs(end1 - 1, end2 - 1);
        }
        int ans = lcs(end1 - 1, end2);
        ans = Math.max(ans, lcs(end1, end2 - 1));
        dp[end1][end2] = ans;
        return ans;
    }
}
