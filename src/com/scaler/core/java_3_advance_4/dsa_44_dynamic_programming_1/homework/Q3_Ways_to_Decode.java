package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.homework;

/**
 * @created 02/04/23 10:25 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Ways_to_Decode {
    int dp[];
    int mod = 1000000007;

    //top down approach using memoization
    private int numDecodings(String A) {
        int n = A.length();
        if (A.charAt(0) == '0')
            return 0;
        if (n == 1)
            return 1;
        dp = new int[A.length()];
        return findWays(0, n, A);
    }

    private int findWays(int index, int n, String A) {
        if (index >= n)
            return 1;
        if (A.charAt(index) == '0')
            return 0;
        if (dp[index] != 0)
            return dp[index];

        int a = findWays(index + 1, n, A);
        int b = 0;
        if ((index + 1) < n &&
                (A.charAt(index) == '1' || (A.charAt(index) == '2' && A.charAt(index + 1) >= '0' && A.charAt(index + 1) <= '6'))) {
            b = findWays(index + 2, n, A);
        }
        dp[index] = (a + b) % mod;
        return dp[index] % mod;
    }

    //bottom up approach : iterative
    private int numDecodings_1(String A) {
        int mod = 1000000007;
        int dp[] = new int[A.length() + 1];
        if (A.charAt(0) == '0')
            return 0;
        int n = A.length();
        dp[0] = 1; // empty string
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (A.charAt(i - 1) >= '1' && A.charAt(i - 1) <= '9')
                dp[i] = dp[i - 1];
            if (A.charAt(i - 2) == '1' || (A.charAt(i - 2) == '2' && A.charAt(i - 1) >= 0 && A.charAt(i - 1) <= '6'))
                dp[i] = (dp[i] + dp[i - 2]) % mod;
        }

        return dp[n] % mod;
    }
}
