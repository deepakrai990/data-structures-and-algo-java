package com.scaler.core.java_3_advance_1.dsa_07_maths_GCD.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:49 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Enumerating_GCD {
    private static String solve(String A, String B) {
        return A.equals(B) ? A : "1";
    }
    public static void main(String[] args) {
        String A = "1";
        String B = "3";
        String result = solve(A, B);
        PrintUtils.printString(result);
    }
}
