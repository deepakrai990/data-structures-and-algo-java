package com.scaler.core.java_3_advance_2.dsa_14_sorting_3.assignment;

/**
 * @created 02/04/23 7:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_QuickSort {
    private static int[] solve(int[] A) {
        quick(A, 0, A.length - 1);
        return A;
    }


    private static void quick(int[] A, int start, int end) {
        if (start >= end) return;
        int rand = (int) (Math.random() * (end - start + 1) + start);
        swap(A, start, rand);
        int index = partition(A, start, end);
        quick(A, start, index - 1);
        quick(A, index + 1, end);
    }


    private static int partition(int[] A, int start, int end) {
        int pivot = A[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (pivot > A[j]) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, end);
        return i + 1;
    }


    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
