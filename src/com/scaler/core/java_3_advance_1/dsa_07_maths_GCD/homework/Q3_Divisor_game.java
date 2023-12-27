package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Divisor_game {
    private static int solve(int A, int B, int C) {
        int gcdValue = B > C ? gcd(B, C) : gcd(C, B);
        int lcmValue = B * C / gcdValue;
        return A/lcmValue;
    }
    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    public static void main(String[] args) {
        int A = 12;
        int B = 3;
        int C = 2;
        int result = solve(A, B, C);
        PrintUtils.printInt(result);
    }
}
