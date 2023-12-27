package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.homework;

/**
 * @created 09/02/23 12:24 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int[][] A, int B) {
        int[][] ps = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == 0) {
                    ps[i][j] = A[i][j];
                } else {
                    ps[i][j] = ps[i][j - 1] + A[i][j];
                }
            }
        }
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A.length; i++) {
                if (i != 0) {
                    ps[i][j] = ps[i][j] + ps[i - 1][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i + B - 1 < A.length && j + B - 1 < A.length) {
                    int sum = ps[i + B - 1][j + B - 1];
                    if (j > 0) {
                        sum = sum - ps[i + B - 1][j - 1];
                    }
                    if (i > 0) {
                        sum = sum - ps[i - 1][j + B - 1];
                    }
                    if (i > 0 && j > 0) {
                        sum += ps[i - 1][j - 1];
                    }
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        int B = 3;
        int result = solve(A, B);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
