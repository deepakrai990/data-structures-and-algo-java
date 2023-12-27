package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    private static String longestCommonPrefix(String[] A) {
        String prefix = A[0];
        for (int i = 1; i < A.length; i++) {
            while (A[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
        String result = longestCommonPrefix(A);
        PrintUtils.printString(result);
    }
}
