package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_toupper {
    private static char[] to_upper(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 'a' && A[i] <= 'z') {
                A[i] = (char) (A[i] ^ (1 << 5));
            }
        }
        return A;
    }

    public static void main(String[] args) {
        char[] A = {'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        char[] result = to_upper(A);
        PrintUtils.printCharArr(result);
    }
}
