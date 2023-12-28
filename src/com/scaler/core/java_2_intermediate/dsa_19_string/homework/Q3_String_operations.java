package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_String_operations {
    private static String solve(String A) {
        String s = A + A;
        String newer = s.replaceAll("([A-Z])", "");
        String newest = newer.replaceAll("[aeiou]","#");
        return newest;
    }
    public static void main(String[] args) {
        String A="AbcaZeoB";
        String result = solve(A);
        PrintUtils.printString(result);
    }
}
