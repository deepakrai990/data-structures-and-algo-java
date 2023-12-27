package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 22/12/23
 * @project scaler_course_code
 */
public class Q2_Find_the_length_of_longest_strictly_increasing_subsequence_3 {
    private static int[][] dp;
    private static int solve(int[] A, int n) {
        dp= new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lis(A, 0, -1, n);
    }
    private static int lis(int[] A, int idx, int prev_idx, int n) {
        if (idx == n) {
            return 0;
        }
        if (dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }
        int notTake = lis(A, idx + 1, prev_idx, n);
        int take = Integer.MIN_VALUE;
        if (prev_idx == -1 || A[idx] > A[prev_idx]) {
            take = 1 + lis(A, idx + 1, idx, n);
        }
        return dp[idx][prev_idx + 1] = Math.max(take, notTake);
    }
    public static void main(String[] args) {
        int[] a = {2, -1, 6, 3, 7, 9}; // {10, 3, 12, 7, 2, 9, 11, 20, 11, 13, 6, 8}; // {3, 10, 2, 1, 20};
        int n = a.length;
        System.out.println("Length of Longest Increasing Subsequence: " + solve(a, n));
    }
}
