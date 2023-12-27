package com.scaler.core.java_3_advance_3.dsa_27_stacks_1.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 02/04/23 6:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Redundant_Braces {
    private static int braces(String A) {
        int N = A.length();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            char ch = A.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                stk.push(ch);
            } else if (ch == ')' && stk.peek() == '(') {
                return 1; //if there's no operator behind ')' -- it has redundant braces
            } else if (ch == ')' && stk.peek() != '(') {
                while (stk.peek() != '(') {
                    stk.pop(); //keep removing till stack has '(' as peek element
                }
                stk.pop(); //remove the '(' bracket also -- till this point valid exp part has been removed from stack
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "((a+b))";
        int result = braces(A);
        PrintUtils.print(result);
    }
}
