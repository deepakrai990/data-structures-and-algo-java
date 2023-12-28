package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Simple_Reverse {
    private static String solve(String A) {
        int aLength = A.length();
        StringBuilder sb = new StringBuilder(A);
        int start = 0;
        int end = aLength - 1;
        while (start < end) {
            sb.setCharAt(start, A.charAt(end));
            sb.setCharAt(end, A.charAt(start));
            start++;
            end--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "scaler";
        String result = solve(A);
        PrintUtils.printString(result);
    }
}
