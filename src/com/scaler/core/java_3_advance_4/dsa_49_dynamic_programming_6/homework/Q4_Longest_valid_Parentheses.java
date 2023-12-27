package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.homework;

/**
 * @created 02/04/23 9:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Longest_valid_Parentheses {
    private static int longestValidParentheses(String A) {
        int n = A.length();
        int[] count = new int[n];

        int ans = 0;
        for (int i = 1; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                if (A.charAt(i - 1) == '(') {
                    count[i] = i - 2 >= 0 ? count[i - 2] + 2 : 2;
                } else if (i - count[i - 1] - 1 >= 0 && A.charAt(i - count[i - 1] - 1) == '(') {
                    count[i] = 2 + count[i - 1];
                    count[i] = i - count[i] >= 0 ? count[i - count[i]] + count[i] : count[i];
                }
            }
            ans = Math.max(ans, count[i]);
        }
        return ans;
    }
}
