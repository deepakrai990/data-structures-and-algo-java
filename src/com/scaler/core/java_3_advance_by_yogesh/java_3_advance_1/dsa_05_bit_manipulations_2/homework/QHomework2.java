package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_05_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 10/02/23 9:53 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++){
            int xor = A[i] ^ A[i + 1];
            if(xor < min) {
                min = xor;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] A = {0, 4, 7, 9};
        int result = findMinXor(A);
        PrintUtils.printInt(result);
    }
}
