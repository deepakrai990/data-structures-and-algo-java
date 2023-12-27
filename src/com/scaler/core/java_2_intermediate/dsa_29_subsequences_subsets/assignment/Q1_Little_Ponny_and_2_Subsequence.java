package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 05/03/23 6:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Little_Ponny_and_2_Subsequence {
    private static String solve(String A) {
        char firstmin = 'z';
        char secondmin = 'z';
        int index = -1;

        int n = A.length();
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) < firstmin) {
                firstmin = A.charAt(i);
                index = i;
            }
        }
        for (int j = index + 1; j < n; j++) {
            if (A.charAt(j) < secondmin) {
                secondmin = A.charAt(j);
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(firstmin);
        ans.append(secondmin);
        return ans.toString();
    }

    public static void main(String[] args) {
        String  A = "abcdsfhjagj";
        String result = solve(A);
        PrintUtils.printString(result);
    }
}
