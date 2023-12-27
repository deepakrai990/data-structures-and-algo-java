package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 18/01/23 11:01 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
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
