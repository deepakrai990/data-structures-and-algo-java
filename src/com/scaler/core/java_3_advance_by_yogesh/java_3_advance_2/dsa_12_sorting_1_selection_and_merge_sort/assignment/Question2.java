package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
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
