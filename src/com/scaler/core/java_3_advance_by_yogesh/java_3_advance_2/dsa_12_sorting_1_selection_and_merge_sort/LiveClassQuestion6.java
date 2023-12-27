package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

import java.util.Arrays;

/**
 * @created 28/01/23 5:27 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion6 {
    /**
     * Given array A[N], sort it without using inbuilt function
     * T.C = O(n log n)
     * S.C = O(n)
     * **/
    private static void mergeSort(int[] a, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }
    private static void merge(int[] a, int s, int m, int e) {
        int[] c = new int[e - s + 1];
        int p1 = s;
        int p2 = m + 1;
        int k = 0;
        while (p1 <= m && p2 <= e) {
            if (a[p1] < a[p2]) {
                c[k] = a[p1];
                k++;
                p1++;
            } else {
                c[k] = a[p2];
                k++;
                p2++;
            }
        }
        while (p1 <= m) {
            c[k] = a[p1];
            k++;
            p1++;
        }
        while (p2 <= e) {
            c[k] = a[p2];
            k++;
            p2++;
        }
        for (int i = 0; i < c.length; i++) {
            a[i + s] = c[i];
        }
    }
    public static void main(String[] args) {
        int[] A = {4, 8, -1, 2, 6, 9, 11, 3, 4, 7, 13, 0};
        int start = 0;
        int end = A.length - 1;
        System.out.println("Before Sorting Results : " + Arrays.toString(A));
        mergeSort(A, start, end);
        System.out.println("After SortingResults : " + Arrays.toString(A));
    }
}
