package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 10:23 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Minimum_Number_of_Squares {
    int DP[] = new int[1000001];

    public int countMinSquares(int A) {
        Arrays.fill(DP, -1);
        return minSq(A);
    }

    private int minSq(int i) {
        if (i == 0) return 0;
        if (DP[i] == -1) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, minSq(i - (j * j)));
            }
            DP[i] = ans + 1;
        }
        return DP[i];
    }
}
