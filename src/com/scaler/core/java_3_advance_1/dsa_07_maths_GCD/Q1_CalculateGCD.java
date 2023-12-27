package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 16/09/23 8:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_CalculateGCD {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 24, b = 16;
        int result = gcd(a, b);
        PrintUtils.print(result);
    }
}
