package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms.homework;

import java.util.Arrays;

/**
 * @created 02/04/23 11:22 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Assign_Mice_to_Holes {
    private static int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, Math.abs(A[i] - B[i]));
        }
        return max;
    }



}
