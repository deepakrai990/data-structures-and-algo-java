package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Prime_Modulo_Inverse {
    private static int solve(int A, int B) {
        if (A == 0)
            return 0;
        return pow(A, B - 2, B);
    }

    private static int pow(int A, int B, int C) {
        if (B == 0)
            return 1;
        long halfPower = pow(A, B / 2, C);
        long interimResult = halfPower % C * halfPower % C;
        return ((B % 2 == 0) ? (int) ((interimResult) + C) % C : (int) ((interimResult * A % C) + C) % C);
    }

    public static void main(String[] args) {
        int A = 6;
        int B = 23;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
