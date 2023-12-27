package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_09_maths_4_combinatorics_basic.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 6:23 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static String convertToTitle(int A) {
        String res = "";
        while (A > 0) {
            int temp = (A - 1) % 26;
            res = (char) ('A' + temp) + res;
            A = (A - 1) / 26;
        }
        return res;
    }

    public static void main(String[] args) {
        int A = 27;
        String result = convertToTitle(A);
        PrintUtils.printString(result);
    }
}
