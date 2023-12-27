package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.assignment;

/**
 * @created 17/01/23 11:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int solve(int[] A) {
        int N = A.length;
        int prefixGCD[] = preparePrefixGCD(A, N);
        int suffixGCD[] = prepareSuffixGCD(A, N);
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                max = Math.max(suffixGCD[i + 1], max);
            }
            if (i == N - 1) {
                max = Math.max(prefixGCD[i - 1], max);
            }
            if (i != 0 && i != N - 1) {
                max = Math.max((gcd(prefixGCD[i - 1], suffixGCD[i + 1])), max);
            }
        }
        return max;
    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    private static int[] preparePrefixGCD(int[] A, int N) {
        int prefixGCD[] = new int[N];
        prefixGCD[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], A[i]);
        }
        return prefixGCD;
    }

    private static int[] prepareSuffixGCD(int[] A, int N) {
        int suffixGCD[] = new int[N];
        suffixGCD[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(A[i], suffixGCD[i + 1]);
        }
        return suffixGCD;
    }

    public static void main(String[] args) {
        int[] A = {12, 15, 18};
        int result = solve(A);
        System.out.println("Result : " + result);
    }
}
