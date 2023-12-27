package com.scaler.core.java_3_advance_4.dsa_50_dynamic_programming_7.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 8:48 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Unique_Binary_Search_Trees_II {
    private static int numTrees(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, 1);
        int total;
        for (int i = 2; i <= A; i++) {
            total = 0;
            for (int j = 1; j <= i; j++) {
                int l = j - 1;
                int r = i - j;
                total = total + (dp[l] * dp[r]);
            }
            dp[i] = total;
        }
        return dp[A];
    }
}
