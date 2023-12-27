package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 9:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Russian_Doll_Envelopes {
    public int solve(int[][] A) {
        int n = A.length;
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n];

        //same as length of a longest increasing subsequence problem
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j][1] < A[i][1] && A[j][0] < A[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int maxLength = 0;
        for (int l : dp) {
            maxLength = Math.max(maxLength, l);
        }
        return maxLength + 1;
    }
}
