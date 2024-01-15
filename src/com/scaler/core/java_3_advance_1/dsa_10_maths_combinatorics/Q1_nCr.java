package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_nCr {
    private static int ncr(int N, int r) {
        int nFact = factorial(N);
        int rFact = factorial(r);
        int n_r_fact = factorial(N - r);
        return (nFact) / (rFact * n_r_fact);
    }
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    private static int ncr1(int N, int r) {
        int[][] mat = new int[N + 1][r + 1]; // Initialize mat with 0
        for (int i = 0; i <= N; i++) {
            mat[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= r; j++) {
                if (j <= i) {
                    mat[i][j] = mat[i - 1][j] + mat[i - 1][j - 1];
                }
            }
        }
        return mat[N][r];
    }

    public static void main(String[] args) {
        int N = 5; // Total number of items
        int r = 3; // Number of items to select

        int result = ncr(N, r);
        System.out.println("Number of ways to select " + r + " items out of " + N + ": " + result);

        result = ncr1(N, r);
        System.out.println("Number of ways to select " + r + " items out of " + N + ": " + result);
    }
}
