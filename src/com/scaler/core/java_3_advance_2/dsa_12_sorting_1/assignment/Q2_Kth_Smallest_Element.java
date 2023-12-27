package com.scaler.core.java_3_advance_2.dsa_12_sorting_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:32 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Kth_Smallest_Element {
    private static int kthSmallest(final int[] A, int B) {
        int n = A.length;
        for (int i = 0; i < B; i++) {
            int minValue = A[i];
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (A[j] < minValue) {
                    minValue = A[j];
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        }
        return A[B - 1];
    }

    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int B = 3;
        int result = kthSmallest(A, B);
        PrintUtils.printInt(result);
    }
}
