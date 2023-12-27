package com.scaler.core.java_3_advance_1.dsa_05_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 7:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Min_XOR_value {
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
        PrintUtils.print(result);
    }
}
