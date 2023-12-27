package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q3_Minimum_numbers_of_perfect_squares_1 {
    /**
     * Problem: Minimum numbers of perfect squires required to reach sum = N
     * **/
    private static int DP[] = new int[1000001];
    private static int countMinSquares(int N) {
        Arrays.fill(DP, Integer.MAX_VALUE);
        return minSq(N);
    }
    private static int minSq(int i) {
        if (i == 0) return 0;
        if (DP[i] == Integer.MAX_VALUE) {
            for (int j = 1; j * j <= i; j++) {
                DP[i] = Math.min(DP[i], minSq(i - (j * j)) + 1);
            }
        }
        return DP[i];
    }
    public static void main(String[] args) {
        int N = 12;
        int result = countMinSquares(N);
        PrintUtils.print(result);
    }
}
