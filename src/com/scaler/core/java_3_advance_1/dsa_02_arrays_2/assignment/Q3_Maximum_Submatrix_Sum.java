package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Maximum_Submatrix_Sum {
    private static long solve(int[][] A) {
        int M = A.length - 1;
        int N = A[0].length - 1;
        long[][] temp = new long[M+1][N+1];
        long max = Long.MIN_VALUE;

        for (int i = M; i > -1; i--) {
            for (int j = N; j > -1; j--) {
                temp[i][j] = A[i][j];
                if (j + 1 <= N) {
                    temp[i][j] += temp[i][j + 1];
                }
                if (i + 1 <= M) {
                    temp[i][j] += temp[i + 1][j];
                }
                if (j + 1 <= N && i + 1 <= M) {
                    temp[i][j] -= temp[i + 1][j + 1];
                }
                max = Math.max(max, temp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] A = {
                {-5, -4, -3},
                {-1, 2, 3},
                {2,  2,  4}
        };
        long result = solve(A);
        PrintUtils.print(result);
    }
}
