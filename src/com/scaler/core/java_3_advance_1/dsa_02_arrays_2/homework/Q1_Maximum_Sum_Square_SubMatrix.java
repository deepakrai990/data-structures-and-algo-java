package com.scaler.core.java_3_advance_1.dsa_02_arrays_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 02/04/23 8:07 pm
 * @project scaler_course_code
 */
public class Q1_Maximum_Sum_Square_SubMatrix {
    private static int solve(int[][] A, int B) {
        int N = A.length;
        int sum = Integer.MIN_VALUE;
        for (int j = 1; j < N; j++) {
            A[0][j] = A[0][j - 1] + A[0][j];
        }
        for (int i = 1; i < N; i++) {
            A[i][0] = A[i - 1][0] + A[i][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                A[i][j] = A[i][j] + A[i][j - 1] + A[i - 1][j] - A[i - 1][j - 1];
            }
        }
        B = B - 1;
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 < N; j1++) {
                if (i1 + B < N && j1 + B < N) {
                    int tempSum = A[i1 + B][j1 + B];
                    if (i1 - 1 > -1) {
                        tempSum -= A[i1 - 1][j1 + B];
                    }
                    if (j1 - 1 > -1) {
                        tempSum -= A[i1 + B][j1 - 1];
                    }
                    if (i1 - 1 > -1 && j1 - 1 > -1) {
                        tempSum += A[i1 - 1][j1 - 1];
                    }
                    sum = Math.max(sum, tempSum);
                } else {
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int B = 3;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
