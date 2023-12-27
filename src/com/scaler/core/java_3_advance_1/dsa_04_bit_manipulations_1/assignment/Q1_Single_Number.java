package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:58 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Single_Number {
    private static int singleNumber(final int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        int result = singleNumber(A);
        PrintUtils.print(result);
    }
}
