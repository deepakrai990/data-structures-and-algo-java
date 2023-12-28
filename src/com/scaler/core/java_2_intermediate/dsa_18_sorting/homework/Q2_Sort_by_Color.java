package com.scaler.core.java_2_intermediate.dsa_18_sorting.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 1:26 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sort_by_Color {
    private static int[] sortColors(int[] A) {
        int b[] = new int[A.length];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[j] == i) b[k++] = A[j];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        int[] results = sortColors(A);
        PrintUtils.print1DArray(results);
    }
}
