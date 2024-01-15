package com.scaler.core.java_3_advance_1.dsa_01_arrays_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q2_Add_val_from_start_to_end_onwards {
    private static int[] addValByStartToEndThroughQueries(int[] A, int[][] Q) {
        int N = A.length, M = Q.length;
        while (M-- > 0) {
            // Given index and value
            int start = Q[M][0];
            int end = Q[M][1];
            int value = Q[M][2];
            A[start] += value;
            if (end + 1 < N) {
                A[end + 1] -= value;
            }
        }
        // Create a prefix sum array in original array
        // A[0] -> Do nothing
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }
    public static void main(String[] args) {int[] A = new int[10];
        int[][] Q = {{3, 6, 1}, {2, 7, 3}, {5, 8, -3}, {1, 9, 2}};
        PrintUtils.print(A);

        int[] results = addValByStartToEndThroughQueries(A, Q);
        PrintUtils.print(results);
    }
}
