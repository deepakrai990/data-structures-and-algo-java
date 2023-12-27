package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 8:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int[] solve(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int[] c = new int[n + m];
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        while (p1 < n && p2 < m) {
            if (A[p1] < B[p2]) {
                c[k++] = A[p1++];
            } else {
                c[k++] = B[p2++];
            }
        }
        while (p1 < n) {
            c[k++] = A[p1++];
        }
        while (p2 < m) {
            c[k++] = B[p2++];
        }
        return c;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        int[] results = solve(A, B);
        PrintUtils.print1DArray(results);
    }
}
