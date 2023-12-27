package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_28_stacks_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @created 04/03/23 8:34 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static String solve(String A) {

        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('(', -1);
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char inp = A.charAt(i);
            if (Character.isAlphabetic(inp)) {
                output.append(inp);
            } else if (inp == '(') {
                stack.push(inp);
            } else if (inp == ')') {
                while (stack.peek() != '(') {
                    output.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                if (stack.size() == 0) {
                    stack.push(inp);
                } else {
                    int peekPrecedence = precedence.get(stack.peek());
                    int curPrecedence = precedence.get(inp);
                    while (peekPrecedence >= curPrecedence) {
                        output.append(stack.peek());
                        stack.pop();
                        if (stack.size() == 0) {
                            peekPrecedence = -1;
                        } else {
                            peekPrecedence = precedence.get(stack.peek());
                        }
                    }
                    stack.push(inp);
                }
            }
        }
        while (stack.size() != 0) {
            output.append(stack.peek());
            stack.pop();
        }
        return output.toString();
    }
    private static String solve_1(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();
        StringBuilder str = new StringBuilder();

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('^',1);
        precedence.put('/',2);
        precedence.put('*',2);
        precedence.put('+',3);
        precedence.put('-',3);

        for(int i = 0; i < n; i++){
            char c = A.charAt(i);
            if(c >= 'a' && c <= 'z')
            str.append(c);
            else if(stack.isEmpty() && (precedence.containsKey(c) || c == '('))
            stack.push(c);
            else if(c == '(')
            stack.push(c);
            else if(precedence.containsKey(c)){
                while(!stack.isEmpty() && stack.peek() != '('
                        && precedence.get(stack.peek()) <= precedence.get(c)){
                    str.append(stack.pop());
                }
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    str.append(stack.pop());
                }
                //remove opening bracket
                stack.pop();
            }
        }
        if(stack.isEmpty()) return str.toString();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String  A = "a+b*(c^d-e)^(f+g*h)-i";
        String result = solve(A);
        PrintUtils.printString(result);
        PrintUtils.printNewLine();
        result = solve_1(A);
        PrintUtils.printString(result);
    }
}
