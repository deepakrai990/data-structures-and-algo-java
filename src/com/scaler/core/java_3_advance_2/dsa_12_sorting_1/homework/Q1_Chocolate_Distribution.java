package com.scaler.core.java_3_advance_2.dsa_12_sorting_1.homework;

import java.util.Arrays;

/**
 * @created 02/04/23 7:35 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Chocolate_Distribution {
    private static int solve(int[] A, int B) {
        if (A.length == 0 || B == 0) {
            return 0;
        }
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + B - 1 < A.length; i++) {
            int d = A[i + B - 1] - A[i];
            if (d < min) {
                min = d;
            }
        }
        return min;
    }
}
