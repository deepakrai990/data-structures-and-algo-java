package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_4.dsa_43_greedy_algorithms.umang.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 31/03/23 11:50 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Another_Coin_Problem {
    private static int solve(int A) {
        int maxVal = Integer.MAX_VALUE;
        int minCoin = 0;
        int i = 15;
        while (A > 0) {
            while (maxVal > A) {
                maxVal = (int) Math.pow(5, i);
                i--;
            }
            A = A - maxVal;
            minCoin++;
        }
        return minCoin;
    }

    public static void main(String[] args) {
        int A = 47;
        int result = solve(A);
        PrintUtils.print(result);
    }
}
