package com.scaler.core.java_3_advance_3.dsa_27_stacks_1.assignment;

import java.util.Stack;

/**
 * @created 02/04/23 6:36 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Balanced_Paranthesis {

    private static int solve(String A) {
        Stack<Character> stk = new Stack<>();
        int temp = 0;
        while (temp < A.length()) {
            //If its opened bracket then push it
            if (A.charAt(temp) == '(' || A.charAt(temp) == '[' || A.charAt(temp) == '{') {
                stk.push(A.charAt(temp));
            } // If closed bracket then pop top one and check the exact one and stack should not be empty then pop
            else if (A.charAt(temp) == ')') {
                if (stk.empty() || stk.peek() != '(') return 0;
                stk.pop();
            } else if (A.charAt(temp) == '}') {
                if (stk.empty() || stk.peek() != '{') return 0;
                stk.pop();
            } else if (A.charAt(temp) == ']') {
                if (stk.empty() || stk.peek() != '[') return 0;
                stk.pop();
            }
            temp++;
        }
        // Stack should be empty at the end of string iteration then only it will be balanced paranthesis
        if (stk.empty()) return 1;
        return 0;
    }
}
