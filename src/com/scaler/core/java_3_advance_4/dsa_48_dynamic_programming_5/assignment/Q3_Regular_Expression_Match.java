package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5.assignment;

import java.util.Arrays;

/**
 * @created 02/04/23 10:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Regular_Expression_Match {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int[][] dpArr; // define a 2D integer array to store the results of subproblems

    private int isMatch(final String A, final String B) {
        // In order to avoid heap memory exception/error create a StringBuilder to remove consecutive asterisks from B
        StringBuilder strB = new StringBuilder();
        strB.append(B.charAt(0)); // append the first character of B
        for (int i = 1; i < B.length(); i++) {
            if (B.charAt(i) != '*') { // if the current character is not an asterisk, append it
                strB.append(B.charAt(i));
            } else if (B.charAt(i) == '*' && B.charAt(i - 1) != '*') {
                // if the current character is an asterisk and the previous character is not an asterisk,
                // append it to the StringBuilder
                strB.append('*');
            }
        }
        // initialize the 2D integer array with -1
        dpArr = new int[A.length() + 1][strB.toString().length() + 1];
        for (int[] x : dpArr) {
            Arrays.fill(x, -1);
        }
        // call the recursion function and return the result
        return recursion(A, strB.toString(), 0, 0);
    }

    private int recursion(String A, String B, int i, int j) {
        // if both A and B have been traversed completely, return true
        if (i == A.length() && j == B.length())
            return 1;
        // if A has been traversed completely but B has remaining characters other than asterisks, return false
        if (i == A.length()) {
            for (int x = j; x < B.length(); x++) {
                if (B.charAt(x) != '*')
                    return 0;
            }
            return 1;
        }
        // if B has been traversed completely but A has remaining characters, return false
        if (j == B.length())
            return 0;
        // if the result of the current subproblem has already been computed, return it
        if (dpArr[i][j] != -1)
            return dpArr[i][j];

        char iTemp = A.charAt(i);
        char jTemp = B.charAt(j);
        // if the current characters match or the current character in B is a '?', move to the next characters in both strings
        if (jTemp == '?' || iTemp == jTemp) {
            dpArr[i][j] = recursion(A, B, i + 1, j + 1);
        }
        // if the current character in B is an asterisk, either skip the current character in A or move to the next character in B
        else if (jTemp == '*') {
            dpArr[i][j] = recursion(A, B, i + 1, j) | recursion(A, B, i, j + 1);
        }
        // if none of the above conditions are met, the strings do not match
        else
            dpArr[i][j] = 0;

        return dpArr[i][j];
    }
}
