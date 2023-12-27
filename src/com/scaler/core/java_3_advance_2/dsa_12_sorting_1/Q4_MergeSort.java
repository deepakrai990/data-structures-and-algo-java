package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/23 8:37 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_MergeSort {
    private static void mergeSort(int[] A, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }
    private static void merge(int[] A, int start, int mid, int end) {
        int P1 = start, P2 = mid + 1, P3 = 0;
        int[] tempArr = new int[end - start + 1];
        while (P1 <= mid && P2 <= end) {
            if (A[P1] < A[P2]) tempArr[P3++] = A[P1++];
            else tempArr[P3++] = A[P2++];
        }
        while (P1 <= mid)
            tempArr[P3++] = A[P1++];
        while (P2 <= end)
            tempArr[P3++] = A[P2++];
        for (int i = start; i <= end; i++)
            A[i] = tempArr[i - start];
    }
    public static void main(String[] args) {
        int[] A = {18, 17, 15, 2, 6, 10, 9, 1, 8};
        int start = 0, end = A.length - 1;
        mergeSort(A, start, end);
        PrintUtils.print1DArray(A);
    }
}
