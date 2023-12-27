package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:51 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_A_B_and_Modulo {
    private static int solve(int A, int B) {
        if(A > B) {
            return A - B;
        }
        return B - A;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 10;
        int result = solve(A, B);
        PrintUtils.print(result);
    }
}
