package com.scaler.core.java_3_advance_2.dsa_14_sorting_3;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 26/09/23 10:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_QuickSort {
    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int pivot = partition(A, start, end);
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
    }
    private static int partition(int[] A, int start, int end) {
        int P1 = start + 1, P2 = end;
        while (P1 <= P2) {
            if (A[start] >= A[P1]) P1++;
            else if (A[start] < A[P2]) P2--;
            else {
                swap(A, P1, P2);
                P1++; P2--;
            }
        }
        swap(A, start, P2);
        return P2;
    }
    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
    public static void main(String[] args) {
        int[] A = {18, 8, 6, 3, 11, 14, 23, 20, 31, 27};
        int start = 0, end = A.length - 1;
        PrintUtils.print1DArray(A);
        quickSort(A, start, end);
        PrintUtils.printNewLine();
        PrintUtils.print1DArray(A);
    }
}
