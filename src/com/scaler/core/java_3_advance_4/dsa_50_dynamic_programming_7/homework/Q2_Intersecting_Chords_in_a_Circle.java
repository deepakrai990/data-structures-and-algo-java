package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.homework;

/**
 * @created 02/04/23 8:49 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Intersecting_Chords_in_a_Circle {
    private static int chordCnt(int A) {
        int[] dp = new int[A + 1];
        int mod = 1000000007;
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= A; i++) {
            long val = 0;
            for (int j = 0; j < i; j++) {
                val = (val + (long) dp[j] * dp[i - 1 - j]) % mod;
            }
            dp[i] = (int) val;
        }
        return dp[A];
    }
}
