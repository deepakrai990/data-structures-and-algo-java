package com.scaler.core.java_3_advance_3.dsa_27_stacks_1;

import java.util.Stack;

/**
 * @author Deepak Kumar Rai
 * @created 22/10/23
 * @project scaler_course_code
 */
public class Q3_Evaluate_Postfix_Expression {
    private static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convert character digit to integer
            } else if (c == ' ') {
                continue; // Skip whitespace
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "2 3 1 * + 9 -";
        // String postfixExpression = "10 4 2 - / 6 * 9 +"; // need to work for this example
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Result: " + result);
    }
}
