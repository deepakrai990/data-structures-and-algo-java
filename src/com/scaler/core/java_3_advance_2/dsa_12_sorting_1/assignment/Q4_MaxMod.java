package com.scaler.core.java_3_advance_2.dsa_12_sorting_1.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_MaxMod {
    private static int solve(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int maxNum = A[len - 1];
        int secMaxNum = 0;
        for (int i = 2; i <= len; i++) {
            if (A[len - i] != maxNum) {
                secMaxNum = A[len - i];
                break;
            }
        }
        return secMaxNum % maxNum;
    }
}
