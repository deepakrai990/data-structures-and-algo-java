package com.scaler.core.java_3_advance_2.dsa_12_sorting_1.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Array_with_consecutive_elements {
    private static int solve(int[] A) {
        Arrays.sort(A);
        int flag = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1])
                flag = 0;

        }
        return flag;
    }
}
