package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Implement_Power_Function {
    private static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0 && A != 0) {
            return 1;
        }
        long ans = (pow(A, B / 2, C) + C) % C;
        if (B % 2 == 0) {
            return (int) ((ans * ans) % C);
        } else {
            return (int) ((((ans * ans) % C * (A) % C) % C + C) % C);
        }
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 3;
        int result = pow(A, B, C);
        PrintUtils.print(result);
    }
}
