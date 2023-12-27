package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Greatest_Common_Divisor {
    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int A = 8;
        int B = 24;
        int result = gcd(A, B);
        PrintUtils.print(result);
    }
}
