package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_06_maths_1_modular_arithmetic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 10:53 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int trailingZeroes(int A) {
        int ans = 0;
        for (int i = 5; i <= A; i = i * 5) {
            ans = ans + (A / i);
        }
        return ans;
    }

    private static int trailingZeroes1(int A) {
        int ans = 0;
        for (int i = 5; A / i >= 1; i = i * 5) {
            ans = ans + (A / i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 5;
        int result = trailingZeroes(A);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        int result1 = trailingZeroes1(A);
        PrintUtils.printInt(result1);
    }
}
