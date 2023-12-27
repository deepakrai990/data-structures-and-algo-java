package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework7 {
    private static int solve(char[] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            char ch = A[i];
            boolean isUpper = ch >= 'A' && ch <= 'Z';
            boolean isLower = ch >= 'a' && ch <= 'z';
            boolean isDigit = ch >= '0' && ch <= '9';
            if (!(isDigit || isLower || isUpper))
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        char[]  A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
