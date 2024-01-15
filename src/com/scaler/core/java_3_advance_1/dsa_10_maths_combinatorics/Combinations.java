package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Combinations {
    // Function to calculate the factorial of a number
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    // Function to calculate C(N, r) - combinations of N items taken r at a time
    private static int combinations(int N, int r) {
        if (N < r) {
            return 0; // Invalid input, r should be less than or equal to N
        }
        return factorial(N) / (factorial(r) * factorial(N - r));
    }
    // Function to calculate N choose r using Dynamic Programming
    private static long combinationsUsingDP(int N, int r) {
        long[][] dp = new long[N + 1][r + 1];
        // Base case: C(n, 0) = 1 for all n
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        // Bottom-up calculation of binomial coefficients
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Math.min(i, r); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[N][r];
    }
    public static void main(String[] args) {
        int N = 5; // Total number of items
        int r = 3; // Number of items to select

        int result = combinations(N, r);
        System.out.println("Number of ways to select " + r + " items out of " + N + ": " + result);

        result = (int) combinationsUsingDP(N, r);
        System.out.println("Number of ways to select " + r + " items out of " + N + ": " + result);
    }
}
