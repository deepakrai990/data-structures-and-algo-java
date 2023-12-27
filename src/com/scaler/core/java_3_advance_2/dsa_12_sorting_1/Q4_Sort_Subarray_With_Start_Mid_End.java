package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/23 11:28 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Sort_Subarray_With_Start_Mid_End {
    private static void merge(int[] A, int start, int mid, int end) {
        int P1 = start, P2 = mid + 1, P3 = 0;
        int[] tempArr = new int[end - start + 1];
        while (P1 <= mid && P2 <= end) {
            if (A[P1] < A[P2]) {
                tempArr[P3++] = A[P1++];
            } else {
                tempArr[P3++] = A[P2++];
            }
        }
        // Copy rest of elements
        while (P1 <= mid) {
            tempArr[P3++] = A[P1++];
        }
        while (P2 <= end) {
            tempArr[P3++] = A[P2++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = tempArr[i - start];
        }
    }
    public static void main(String[] args) {
        int[] A = {4, 8, -1, 2, 6, 9, 11, 3, 4, 7, 13, 0};
        int start = 2;
        int mid = 6;
        int end = 9;
        merge(A, start, mid, end);
        PrintUtils.print1DArray(A);
    }
}
