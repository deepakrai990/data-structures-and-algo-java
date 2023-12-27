package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_02_arrays_2_two_dimensional.assignment;

/**
 * @created 09/02/23 9:02 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static long solve(int[][] A) {
        long maxsum = Integer.MIN_VALUE;
        int N = A.length;
        int M = A[0].length;
        int row = N - 1;
        int col = M - 1;
        if (A[row][col] < 0) return A[row][col];
        long[][] pf = new long[N + 1][M + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                long s = (long) A[i][j] + pf[i + 1][j] + pf[i][j + 1] - pf[i + 1][j + 1];
                maxsum = Math.max(s, maxsum);
                pf[i][j] = s;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[][] A = {{-5, -4, -3}, {-1, 2, 3}, {2, 2, 4}};
        long result = solve(A);
        System.out.printf("%s%5d", "Result: ", result);
    }
}
