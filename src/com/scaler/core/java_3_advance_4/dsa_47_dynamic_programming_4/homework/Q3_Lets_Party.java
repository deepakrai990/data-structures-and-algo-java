package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.homework;

import java.util.Arrays;

/**
 * @created 02/04/23 10:12 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Lets_Party {
    int[] dp;

    private int solve(int A) {
        dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return dance(A);
    }

    private int dance(int N) {
        if (N <= 2) {
            return N;
        }
        if (dp[N] == -1) {
            dp[N] = dance(N - 1) + dance(N - 2) * (N - 1);
        }
        return dp[N] % 10003;
    }

    private int solve_1(int A) {
        if (A <= 2)
            return A;
        int mod = 10003, first = 1, second = 2, i = 2, temp = 0;
        while (i++ < A) {
            temp = second + ((i - 1) * first); // i-1 is equal to n-1C1 which means choosing 1 person from n-1 persons to pair up
            temp %= mod;
            first = second;
            second = temp;
        }
        return temp;
    }
}
