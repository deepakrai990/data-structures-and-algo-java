package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Sub_matrix_Sum_Queries {
    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int modNum = 1000000007;
        long[][] pf = getPrefixSumMatrix(A);
        int[] subMatSum = new int[B.length];
        for(int i = 0; i < B.length; i++) {
            // Top-Left index
            int r1 = B[i] - 1;
            int c1 = C[i] - 1;
            // Bottom-Right index
            int r2 = D[i] - 1;
            int c2 = E[i] - 1;
            long sum = pf[r2][c2];
            if(c1 > 0) {
                sum = sum - pf[r2][c1-1];
            }
            if(r1 > 0) {
                sum = sum - pf[r1-1][c2];
            }
            if(r1 > 0 && c1 > 0) {
                sum = sum + pf[r1-1][c1-1];
            }
            subMatSum[i] = (int)(((sum % modNum) + modNum) % modNum);
        }
        return subMatSum;
    }

    private static long[][] getPrefixSumMatrix(int[][] A) {
        /* Row-wise */
        long[][] pf = new long[A.length][A[0].length];
        for (int r = 0; r < A.length; r++) {
            long sum = 0;
            for (int c = 0; c < A[0].length; c++) {
                sum = sum + A[r][c];
                pf[r][c] = sum;
            }
        }
        /*  Column-wise */
        for (int c = 0; c < pf[0].length; c++) {
            long sum = 0;
            for (int r = 0; r < pf.length; r++) {
                sum = sum + pf[r][c];
                pf[r][c] = sum;
            }
        }
        return pf;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};
        int[] results = solve(A, B, C, D, E);
        PrintUtils.print(results);
    }
}
