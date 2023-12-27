package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Calculate_max_subsequence_sum_1 {
    /**
     * Problem: Given A[N], calculate maximum subsequence sum.
     * Note 1: In a subsequence, two adjacent elements cannot be picked.
     * Note 2: Empty subsequence is also valid.
     * Code: Memoization
     * **/
    static int[] DP;
    private static int solve(int[] A, int i) {
        DP = new int[i + 1];
        Arrays.fill(DP, -1);
        return maxSum(A, i);
    }
    private static int maxSum(int[] A, int i) {
        if (i < 0) {
            return 0;
        }
        if (DP[i] == -1) { // Called for 1st time
            DP[i] = Math.max(maxSum(A, i - 1), maxSum(A, i - 2) + A[i]);
        }
        return DP[i];
    }
    public static void main(String[] args) {
        int[] A = {2, -1, -4, 5, 3, -1, 4, 2};
        int N = A.length;
        int result = solve(A, N - 1);
        PrintUtils.print(result);
    }
}
