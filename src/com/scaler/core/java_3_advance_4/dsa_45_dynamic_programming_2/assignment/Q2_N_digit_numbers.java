package com.scaler.core.java_3_advance_4.dsa_45_dynamic_programming_2.assignment;

/**
 * @created 02/04/23 10:19 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_N_digit_numbers {
    Integer dp[][];
    int mod = 1000000007;

    private int solve(int A, int B) {
        dp = new Integer[A + 1][B + 1];
        long ans = 0L;
        for (int i = 1; i < 10; i++) {
            ans += findWays(A - 1, B - i);
            ans %= mod;
        }
        return (int) ans % mod;
    }

    private int findWays(int digitLeft, int sum) {
        if (sum < 0) return 0;
        if (digitLeft == 0 && sum == 0) return 1;
        if (digitLeft == 0) return 0;

        if (dp[digitLeft][sum] != null) return dp[digitLeft][sum];

        long ans = 0L;
        for (int i = 0; i < 10; i++) {
            ans += findWays(digitLeft - 1, sum - i);
            ans %= mod;
        }
        dp[digitLeft][sum] = (int) ans % mod;
        return dp[digitLeft][sum];
    }
}
