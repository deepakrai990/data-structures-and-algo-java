package com.scaler.core.java_3_advance_2.dsa_11_recursion_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 13/10/22 9:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Kth_Symbol_Hard {
    private static int solve(int A, long B) {
        if (A == 1) return 0;
        long previousIndex = B / 2l;
        int digit = solve(A - 1, previousIndex);
        if (digit == 0) {
            return B % 2l == 0 ? 0 : 1;
        } else {
            return B % 2l == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int A = 4;
        long B = 4;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
