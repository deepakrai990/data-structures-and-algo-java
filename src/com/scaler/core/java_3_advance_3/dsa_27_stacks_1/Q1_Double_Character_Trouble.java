package com.scaler.core.java_3_advance_3.dsa_27_stacks_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Double_Character_Trouble {
    /**
     * Double character trouble
     * Given a string s, remove an equal pair of adjacent characters.
     * Return the String without adjacent characters.
     * **/
    private static String solve(String A) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!stk.empty() && stk.peek() == ch) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.peek());
            stk.pop();
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String A = "abccbc";
        String result = solve(A);
        PrintUtils.print(result);
    }
}
