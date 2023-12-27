package com.scaler.core.java_3_advance_4.dsa_47_dynamic_programming_4.assignment;

/**
 * @created 02/04/23 10:11 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Coin_Sum_Infinite {
    //NxB tabulation
    private static int coinchange2(int[] A, int B) {
        int n = A.length;
        int mod = 1000007;
        int dp[][] = new int[n + 1][B + 1];
        //filling 1st row
        dp[0][0] = 1;
        for (int i = 1; i <= B; i++) {
            if (A[0] <= i && i % A[0] == 0) {
                dp[0][i] = 1;
            }
        }

        //filling rest of the dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= B; j++) {
                if (A[i] <= j)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - A[i]]) % mod;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][B];
    }

    //optimized solution
    private static int coinchange2_1(int[] A, int B) {
        int n = A.length;
        int mod = 1000007;
        int prev[] = new int[B + 1];
        //filling 1st row
        prev[0] = 1;
        for (int i = 1; i <= B; i++) {
            if (A[0] <= i && i % A[0] == 0) {
                prev[i] = 1;
            }
        }

        if (n == 1) return prev[B];

        //filling rest of the dp
        int current[] = new int[B + 1];

        for (int i = 1; i < n; i++) {
            current = new int[B + 1];
            for (int j = 0; j <= B; j++) {
                if (A[i] <= j)
                    current[j] = (prev[j] + current[j - A[i]]) % mod;
                else
                    current[j] = prev[j];
            }
            prev = current;
        }
        return current[B];
    }
}
