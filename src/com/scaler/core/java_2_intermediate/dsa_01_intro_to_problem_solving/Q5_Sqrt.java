package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 09/09/22 7:36 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q5_Sqrt {
    /**
     * Given N, Check if it's a perfect squire num or not
     * **/
    private static int sqrt(int N) {
        for (int i = 1; i <= N; i++) {
            if (i * i == N) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int N = 64;
        int result = sqrt(N);
        PrintUtils.print("Squire root of " + N + " is " + result);
    }
}
