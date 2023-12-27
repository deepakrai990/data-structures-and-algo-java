package com.scaler.core.java_3_advance_2.dsa_13_sorting_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 8:17 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Arrays_In_Wave_Form {
    /**
     * Given N distinct array elements. Arrange it in wave form
     * **/
    private static void waveFromArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if ((i & 1) == 0) {
                if (A[i + 1] > A[i]) swap(A, i + 1, i);
            } else {
                if (A[i + 1] < A[i]) swap(A, i + 1, i);
            }
        }
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {8, 2, 4, 10, 9, 3, 6, 14, 7};
        waveFromArray(A);
        PrintUtils.print1DArray(A);
    }
}
