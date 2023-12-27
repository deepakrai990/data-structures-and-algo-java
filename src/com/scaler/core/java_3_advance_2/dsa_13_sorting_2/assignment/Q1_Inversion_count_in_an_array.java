package com.scaler.core.java_3_advance_2.dsa_13_sorting_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:29 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Inversion_count_in_an_array {
    private static final int MOD = 1000000007;
    private static long INVERSION_COUNT = 0L;

    private static int solve(int[] A) {
        int n = A.length;
        mergeSort(A, 0, n - 1);
        return (int) INVERSION_COUNT;
    }

    private static void mergeSort(int[] A, int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);
        merge(A, s, mid, e);
    }

    private static void merge(int[] A, int s, int mid, int e) {
        int n1 = mid - s + 1;
        int n2 = e - mid;
        int A1[] = new int[n1];
        int A2[] = new int[n2];
        int index = 0;
        for (int i = s; i <= mid; i++) {
            A1[index++] = A[i];
        }
        index = 0;
        for (int i = mid + 1; i <= e; i++) {
            A2[index++] = A[i];
        }
        int i = 0, j = 0;
        index = s;

        while (i < n1 && j < n2) {
            if (A1[i] <= A2[j])
                A[index++] = A1[i++];
            else {
                INVERSION_COUNT = (INVERSION_COUNT + (A1.length - i)) % MOD;
                A[index++] = A2[j++];
            }
        }
        while (i < n1) {
            A[index++] = A1[i++];
        }
        while (j < n2) {
            A[index++] = A2[j++];
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 2};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
