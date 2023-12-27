package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.homework;

import java.util.Arrays;

/**
 * @created 10/02/23 8:15 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXOR = A[0] ^ A[1];
        for (int i = 2; i < A.length; i++) {
            minXOR = Math.min(minXOR, A[i] ^ A[i - 1]);
        }
        return minXOR;
    }

    public static void main(String[] args) {
        int[] A = {0, 4, 7, 9};
        int result = findMinXor(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
