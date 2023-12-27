package com.scaler.core.java_3_advance_4.dsa_49_dynamic_programming_6.assignment;

/**
 * @created 02/04/23 9:03 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Palindrome_Partitioning_II {
    int[][] dpArr;

    private int minCut(String A) {
        dpArr = new int[A.length() + 1][A.length() + 1];
        return recursion(A, 0, A.length() - 1);
    }

    private int recursion(String A, int i, int j) {
        if (i == j) return 0;

        if (dpArr[i][j] != 0) return dpArr[i][j];

        boolean isPalindrome = true;
        int s = i, e = j;
        while (s < e) {
            if (A.charAt(s) != A.charAt(e)) {
                isPalindrome = false;
                break;
            }
            s++;
            e--;
        }
        int temp = Integer.MAX_VALUE;
        if (!isPalindrome) {
            for (int k = i; k < j; k++) {
                int x = recursion(A, i, k);
                int y = recursion(A, k + 1, j);
                temp = Math.min(temp, x + y + 1);
            }
            dpArr[i][j] = temp;
            return temp;
        } else return 0;
    }
}
