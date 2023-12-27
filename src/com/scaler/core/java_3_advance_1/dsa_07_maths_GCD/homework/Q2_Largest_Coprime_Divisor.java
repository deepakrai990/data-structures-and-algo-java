package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:50 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Largest_Coprime_Divisor {
    private static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 12;
        int result = cpFact(A, B);
        PrintUtils.printInt(result);
    }
}
