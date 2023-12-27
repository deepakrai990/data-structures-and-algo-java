package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_06_maths_1_modular_arithmetic.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 11:20 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int A, int B) {
        if (A > B) {
            return A - B;
        }
        return B - A;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 10;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
