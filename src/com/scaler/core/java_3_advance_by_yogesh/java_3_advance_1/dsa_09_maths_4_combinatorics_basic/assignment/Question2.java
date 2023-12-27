package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(int A, int B, int C) {
        long numerator = factorial(A, C);
        long denominator = (factorial(B, C) * factorial(A - B, C)) % C;
        long result = (numerator * pow(denominator, C - 2, C)) % C;
        return (int) result;
    }

    private static long factorial(long A, long C) {
        long result = 1;
        for (long i = 2; i <= A; i++) {
            result = (result * i) % C;
        }
        return result;
    }

    private static long pow(long A, long B, long C) {
        long A_new = (A + C) % C;

        if (A_new == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }

        long calculatedResult = pow(A_new, B / 2, C);

        if (B % 2 == 0) {
            return ((calculatedResult * calculatedResult) % C);
        } else {
            return (((calculatedResult * calculatedResult) % C * A_new) % C);
        }
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int C = 13;
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
