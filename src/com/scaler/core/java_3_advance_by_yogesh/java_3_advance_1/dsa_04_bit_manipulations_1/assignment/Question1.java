package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

/**
 * @created 10/02/23 8:12 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
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
        System.out.printf("%s%5d", "Result: ", result);
    }
}
