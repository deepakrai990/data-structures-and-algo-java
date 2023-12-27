package com.scaler.core.java_3_advance_2.dsa_14_sorting_3.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 7:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_the_Difference {
    private static final int MOD = 1000000007;

    private static int solve(int[] A) {
        Arrays.sort(A);
        int max = findMaxSum(A);
        int min = findMinSum(A);

        return (max - min + MOD) % MOD;
    }

    private static int findMaxSum(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += A[i] * Math.pow(2, i) % MOD;
            ans = ans % MOD;
        }
        return ans;
    }

    private static int findMinSum(int[] A) {
        int ans = 0;
        int j = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            ans += A[i] * Math.pow(2, j) % MOD;
            ans = ans % MOD;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 10};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
