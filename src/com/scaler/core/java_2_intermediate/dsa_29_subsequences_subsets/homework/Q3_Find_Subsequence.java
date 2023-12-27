package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 05/03/23 6:07 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Find_Subsequence {
    private static String solve(String A, String B) {
        int k = B.indexOf(A.charAt(0));
        if (k == -1) {
            return "NO";
        }
        int j = 1;
        for (int i = k + 1; j < A.length() && i < B.length(); i++) {
            if (A.charAt(j) == B.charAt(i)) {
                j++;
            }
        }
        if (j == A.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String A = "bit";
        String B = "dfbkjijgbbiihbmmt";
        String result = solve(A, B);
        PrintUtils.printString(result);
    }
}
