package com.scaler.core.java_3_advance_1.dsa_01_arrays_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Add_val_from_index_onwards {
    /**
     * Problem: Given array A[N], where all elements are zero.
     * Given a query Q which has index and value. Add the value from index onwards.
     * **/
    // Bruteforce Approach
    private static int[] addValByIdxThroughQueries(int[] A, int[][] Q) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            for (int k = index; k < N; k++) {
                ans[k] = ans[k] + value;
            }
        }
        return ans;
    }
    // Optimise Approach
    private static int[] addValByIdxThroughQueries1(int[] A, int[][] Q) {
        int N = A.length, M = Q.length;
        while (M-- > 0) {
            // Given index and value
            int index = Q[M][0];
            int value = Q[M][1];
            A[index] += value;
        }
        // Create a prefix sum array in original array
        // A[0] -> Do nothing
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = new int[7];
        int[][] Q = {{2, 4}, {3, -1}, {0, 2}, {4, 1}};
        PrintUtils.print(A);

        int[] results = addValByIdxThroughQueries(A, Q);
        PrintUtils.print(results);

        System.out.println("-----------------------------------------------------");

        int[] A1 = new int[7];
        int[][] Q1 = {{2, 4}, {3, -1}, {0, 2}, {4, 1}};
        PrintUtils.print(A);

        int[] results1 = addValByIdxThroughQueries1(A1, Q1);
        PrintUtils.print(results1);
    }
}
