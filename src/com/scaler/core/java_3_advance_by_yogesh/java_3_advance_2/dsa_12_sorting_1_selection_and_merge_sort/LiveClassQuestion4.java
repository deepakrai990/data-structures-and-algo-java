package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_12_sorting_1_selection_and_merge_sort;

import java.util.Arrays;

/**
 * @created 28/01/23 4:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
    /**
     * Given two sorted arrays, A[N] and B[M]. Create array C[] which contains overall sorted data
     * Example
     * A[4] = {7, 10, 11, 14}
     * B[3] = {3, 8, 9}
     *
     * C[7] = {3, 7, 8, 9, 10, 11, 14}
     * **/

    private static int[] mergeTwoSortedArray(int[] A, int[] B) {
        int N = A.length;
        int M = B.length;
        int[] C = new int[N + M];
        int P1 = 0;
        int P2 = 0;
        int K = 0;
        while (P1 < N && P2 < M) {
            if (A[P1] < B[P2]) {
                C[K] = A[P1];
                K++;
                P1++;
            } else {
                C[K] = B[P2];
                K++;
                P2++;
            }
        }
        while (P1 < N) {
            C[K] = A[P1];
            K++;
            P1++;
        }
        while (P2 < M) {
            C[K] = B[P2];
            K++;
            P2++;
        }
        return C;
    }
    public static void main(String[] args) {
        int[] A = {7, 10, 11, 14};
        int[] B = {3, 8, 9};
        int[] results = mergeTwoSortedArray(A, B);
        System.out.println("Results : " + Arrays.toString(results));
    }
}
