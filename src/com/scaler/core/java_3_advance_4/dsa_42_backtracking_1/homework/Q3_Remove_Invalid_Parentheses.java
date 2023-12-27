package com.scaler.core.java_3_advance_4.dsa_42_backtracking_1.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 11:04 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Remove_Invalid_Parentheses {

    public String[] solve(String A) {
        return removeInvalidParentheses(A);
    }

    private String[] removeInvalidParentheses(String A) {
        int off_left = 0;
        int off_right = 0;

        for (char c : A.toCharArray()) {
            if (c == '(') {
                off_left++;
            }
            if (c == ')') {
                if (off_left > 0)
                    off_left--;
                else
                    off_right++;// extra
            }
        }

        Set<String> result = new HashSet<>();
        helper(0, A, "", off_left, off_right, result, 0);
        String[] ans = new String[result.size()];
        int index = 0;
        for (String valid : result)
            ans[index++] = valid;
        return ans;
    }


    private void helper(int index, String A, String currentString, int off_left, int off_right, Set<String> result, int balance) {
        if (index == A.length()) {
            if (off_left == 0 && off_right == 0) {
                result.add(currentString);
            }
        } else if (balance >= 0) {
            if (A.charAt(index) == '(' && off_left > 0) {
                helper(index + 1, A, currentString, off_left - 1, off_right, result, balance); // not considering current opening bracket
            }
            if (A.charAt(index) == ')' && off_right > 0) {
                helper(index + 1, A, currentString, off_left, off_right - 1, result, balance); // not considering current closing bracket
            }
            int diff = 0;
            if (A.charAt(index) == ')')
                diff = -1;
            if (A.charAt(index) == '(')
                diff = 1;
            helper(index + 1, A, currentString + A.charAt(index), off_left, off_right, result, balance + diff);
        }
    }
}
