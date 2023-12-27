package com.scaler.core.java_2_intermediate.dsa_19_string.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 20/02/23 12:19 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework6 {
    private static int solve(String A, String B) {
        // Get lengths of both strings
        int n1 = A.length();
        int n2 = B.length();
        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return 0;
        // Sort both strings
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        // Compare sorted strings
        for (int i = 0; i < n1; i++) {
            if (aChars[i] != bChars[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String A = "secure";
        String B = "rescue";
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
