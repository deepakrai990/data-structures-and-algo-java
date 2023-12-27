package com.scaler.core.java_3_advance_3.dsa_27_stacks_1.homework;

import java.util.Arrays;
import java.util.Stack;

/**
 * @created 02/04/23 6:38 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Check_two_bracket_expressions {
    private static int solve(String A, String B) {
        char[] strA = calculateSigns(A);
        char[] strB = calculateSigns(B);
        for (int i = 0; i < strA.length; i++) {
            if (strA[i] != strB[i]) {
                return 0;
            }
        }
        return 1;
    }

    private static char[] calculateSigns(String str) {
        Stack<Character> globalOperators = new Stack<Character>();
        char[] outArr = new char[26];
        Arrays.fill(outArr, '+');
        int n = str.length();
        char localOperator = '+';      //This is to keep track of the sign comes immediately before the number
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '-' || ch == '+') {
                if (globalOperators.isEmpty()) {
                    localOperator = ch;
                } else {
                    localOperator = giveProperSign(globalOperators.peek(), ch);
                }
                continue;
            }
            if (ch == '(') {
                globalOperators.push(localOperator);
                continue;
            }
            if (ch == ')') {
                globalOperators.pop();
                continue;
            }
            outArr[ch - 'a'] = localOperator;
        }
        return outArr;
    }

    private static char giveProperSign(char operator1, char operator2) {
        if ((operator1 == '-' && operator2 == '+') || (operator1 == '+' && operator2 == '-')) {
            return '-';
        }
        return '+';
    }
}
