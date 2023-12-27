package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_28_stacks_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Stack;

/**
 * @created 04/03/23 8:33 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int postfix(String[] A) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if ((A[i].equals("+")) || (A[i].equals("-")) || (A[i].equals("*")) || (A[i].equals("/"))) {
                int a = stack.pop();
                int b = stack.pop();

                if (A[i].equals("+"))
                    stack.push(a + b);

                if (A[i].equals("-"))
                    stack.push(b - a);

                if (A[i].equals("*"))
                    stack.push(a * b);

                if (A[i].equals("/"))
                    stack.push(b / a);
            } else
                stack.push(Integer.parseInt(A[i]));
        }

        return stack.pop();
    }

    private static int evalRPN(String[] A) {
        return postfix(A);
    }

    public static void main(String[] args) {
        String[] A = {"2", "1", "+", "3", "*"};
        int result = evalRPN(A);
        PrintUtils.printInt(result);
    }
}
