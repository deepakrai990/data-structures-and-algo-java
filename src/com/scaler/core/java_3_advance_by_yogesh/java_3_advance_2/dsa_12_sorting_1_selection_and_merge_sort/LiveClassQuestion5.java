package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

import java.util.Arrays;

/**
 * @created 28/01/23 5:09 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion5 {
    /**
     * Given array A[N] elements & three indices s, m, e and
     * subarray[s m] is sorted and
     * subarray[m+1 2] is sorted.
     * Sort the subarray from s to e.
     *
     * A[12] = {4, 8, -1, 2, 6, 9, 11, 3, 4, 7, 13, 0};
     * s = 2, m = 6, e = 9;
     * C[e - s + 1] = {-1, 2, 3, 4, 6, 7, 9, 11};
     * **/
    private static void merge(int[] arr, int s, int m, int e) {
        int[] c = new int[e - s + 1];
        int p1 = s;
        int p2 = m + 1;
        int k = 0;
        while (p1 <= m && p2 <= e) {
            if (arr[p1] < arr[p2]) {
                c[k] = arr[p1];
                k++;
                p1++;
            } else {
                c[k] = arr[p2];
                k++;
                p2++;
            }
        }
        while (p1 <= m) {
            c[k] = arr[p1];
            k++;
            p1++;
        }
        while (p2 <= e) {
            c[k] = arr[p2];
            k++;
            p2++;
        }
        for (int i = 0; i < c.length; i++) {
            arr[i + s] = c[i];
        }
    }
    public static void main(String[] args) {
        int[] A = {4, 8, -1, 2, 6, 9, 11, 3, 4, 7, 13, 0};
        int s = 2;
        int m = 6;
        int e = 9;
        merge(A, s, m, e);
        System.out.println("Result : " + Arrays.toString(A));
    }
}
