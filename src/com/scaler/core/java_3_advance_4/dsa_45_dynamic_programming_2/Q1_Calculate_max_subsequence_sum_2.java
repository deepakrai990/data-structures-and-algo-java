package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Calculate_max_subsequence_sum_2 {
    static int[] DP;
    private static int solve(int[] A) {
        DP = new int[A.length];
        Arrays.fill(DP, -1);
        return maxSum(A, 0);
    }
    private static int maxSum(int[] A, int i) {
        if (i >= A.length) {
            return 0;
        }
        if (DP[i] == -1) { // Called for 1st time
            DP[i] = Math.max(maxSum(A, i + 1), maxSum(A, i + 2) + A[i]);
        }
        return DP[i];
    }
    public static void main(String[] args) {
        int[] A = {2, -1, -4, 5, 3, -1, 4, 2};
        int result = solve(A);
        PrintUtils.print(result);
    }
}
