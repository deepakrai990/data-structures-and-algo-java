package com.scaler.core.java_3_advance_1.dsa_03_arrays_3.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 02/04/23 8:04 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Next_Permutation {
    private static int[] nextPermutation(int[] A) {
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = A.length - 1;
            while (j >= 0 && A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }
        reverse(A, i + 1);
        return A;
    }

    private static void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void reverse(int[] A, int start) {
        int end = A.length - 1;
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] results = nextPermutation(A);
        PrintUtils.print(results);
    }
}
