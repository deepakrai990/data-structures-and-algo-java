package com.scaler.core.java_3_advance_2.dsa_11_recursion_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_of_Digits {
    private static int solve(int A) {
        if (A == 0) {
            return 0;
        }
        int rem = A % 10;
        A /= 10;
        return rem + solve(A);
    }
    public static void main(String[] args) {
        int A = 46;
        int result = solve(A);
        PrintUtils.print(result);
    }
}
