package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_28_stacks_1.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Stack;

/**
 * @created 04/03/23 8:34 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(String A) {
        Stack<Character> stk = new Stack<>();//initialise stack
        int n = A.length();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (stk.size() == 0) {
                stk.push(ch);
            } else if (ch == '(' || ch == '[' || ch == '{') { // if char is open just add
                stk.push(ch);
            } else if (ch == ')') { // if char is closed check top element is open otherwise just return false
                char rem = stk.pop();
                if (rem != '(') {
                    return 0;
                }
            } else if (ch == ']') {
                char rem = stk.pop();
                if (rem != '[') {
                    return 0;
                }
            } else if (ch == '}') {
                char rem = stk.pop();
                if (rem != '{') {
                    return 0;
                }
            }
        }
        if (stk.size() == 0) { // size should be empty if string is balanced
            return 1;
        } else {
            return 0;
        }
    }

    private static int solve_1(String A) {
        int n = A.length(), p1 = 0, c = 0;
        // creating HashMap of corresponding parenthesis
        HashMap<Character, Character> par = new HashMap<>();
        par.put('{', '}');
        par.put('[', ']');
        par.put('(', ')');

        //checking for other chars before the start of the series of parenthesis
        while (p1 < n && !(par.containsKey(A.charAt(p1)) || par.containsValue(A.charAt(p1)))) {
            p1++;
            c++;
        }
        // l is where the series starts
        int l = p1;
        int p2 = p1 + 1;

        while (p2 < n) {
            //checking if the current char exists in the HashMap
            if ((par.containsKey(A.charAt(p1)) || par.containsValue(A.charAt(p1))) &&
                    (par.containsKey(A.charAt(p2)) || par.containsValue(A.charAt(p2)))) {
                // if the chars at p1 & p2 match, then p1 decreases and p2 decreases
                if (par.getOrDefault(A.charAt(p1), '0') == A.charAt(p2)) {
                    c += 2;
                    p2++;
                    p1--;
                    if (p1 < l) {
                        p2++;
                        p1 = p2 - 1;
                    }
                }
                // counting pairs of open and close parenthesis
                else if (p2 < n - 1 && par.getOrDefault(A.charAt(p2), '0') == A.charAt(p2 + 1)) {
                    p2 += 2;
                    c += 2;
                }
                // counting pairs of open and close parenthesis backwards
                else if (p1 > 1 && par.getOrDefault(A.charAt(p1 - 1), '0') == A.charAt(p1)) {
                    p1 -= 2;
                }
                // in case of no match jump to next series starting from p2
                else {
                    p2++;
                    p1 = p2 - 1;
                }
            }
            // counting other Character within the series
            else if (!(par.containsKey(A.charAt(p1)) || par.containsValue(A.charAt(p1)))) {
                p1--;
                c++;
            } else if (!(par.containsKey(A.charAt(p2)) || par.containsValue(A.charAt(p2)))) {
                p2++;
                c++;
            }
        }
        // if count matches length of string then return 1, else 0
        if (c == n) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "{([])}";
        int result = solve(A);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve_1(A);
        PrintUtils.printInt(result);
    }
}
