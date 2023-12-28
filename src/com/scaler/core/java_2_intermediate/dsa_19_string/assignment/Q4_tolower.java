package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_tolower {
    private static char[] to_lower(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 'A' && A[i] <= 'Z') {
                A[i] = (char) (A[i] + 32);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        char[] A = {'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        char[] results = to_lower(A);
        PrintUtils.printCharArr(results);
    }
}
