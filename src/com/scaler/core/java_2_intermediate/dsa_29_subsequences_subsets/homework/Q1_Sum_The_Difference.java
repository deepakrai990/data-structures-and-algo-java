package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 05/03/23 6:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_The_Difference {
    private static int solve(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        Arrays.sort(A);
        long max = 0L;
        long min = 0L;
        long pow = 1L;

        for (int i = 0; i < n; i++) {
            max = (max + (A[i] * pow) % mod) % mod;
            min = (min + (A[n - i - 1] * pow) % mod) % mod;
            pow = (pow * 2) % mod;
        }
        return (int) ((max - min + mod) % mod);
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 10};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
