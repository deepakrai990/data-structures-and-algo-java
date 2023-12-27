package com.scaler.core.java_3_advance_2.dsa_12_sorting_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 23/09/23 10:56 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Merge_Two_Sorted_Array {
    private static int[] merge(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int P1 = 0, P2 = 0, P3 = 0;
        int[] C = new int[n + m];
        while (P1 < n && P2 < m) {
            if (A[P1] < B[P2]) {
                C[P3++] = A[P1++];
            } else {
                C[P3++] = B[P2++];
            }
        }
        // Copy rest of the elements
        while (P1 < n) {
            C[P3++] = A[P1++];
        }
        while (P2 < m) {
            C[P3++] = B[P2++];
        }
        return C;
    }
    public static void main(String[] args) {
        int[] a = {-5, -1, 3, 7, 10, 12, 15};
        int[] b = {-4, 0, 2, 8, 9};
        int[] results = merge(a, b);
        PrintUtils.print1DArray(results);
    }
}
