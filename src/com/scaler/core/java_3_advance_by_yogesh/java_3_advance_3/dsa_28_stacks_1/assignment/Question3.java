package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_28_stacks_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 04/03/23 8:34 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static String solve(String A) {
        int n = A.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (st.empty()) {
                st.push(c);
            } else {
                char pk = st.peek();
                if (c == pk) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "abccbc";
        String result = solve(A);
        PrintUtils.printString(result);
    }
}
