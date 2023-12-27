package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:03 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_First_Missing_Integer {
    private static int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            int idx = A[i] - 1;
            if (A[i] != i + 1 && A[i] <= A.length && A[i] >= 1 && A[i] != A[idx]) {
                swap(A, i, idx);
            } else {
                i++;
            }
        }

        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return A.length + 1;
    }

    private static void swap(int[] A, int i, int idx) {
        int temp = A[i];
        A[i] = A[idx];
        A[idx] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};
        int result = firstMissingPositive(A);
        PrintUtils.print(result);
    }
}
