package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.assignment;

/**
 * @created 02/04/23 10:11 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Cutting_a_Rod {
    private static int solve(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int res = 0;
            for (int cut = 1; cut <= i; cut++) {
                res = Math.max(res, A[cut - 1] + dp[i - cut]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
