package com.scaler.core.java_2_intermediate.dsa_19_string.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 20/02/23 12:17 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static String longestPalindrome(String A) {
        int left = 0, right = 0;
        char[] s = A.toCharArray();
        int N = s.length;
        int ans = 0;
        // for add palindrome
        for (int i = 0; i < N; i++) {
            // when palindrome is of odd length with ith index as center
            int len1 = expand(s, i/*p1*/, i/*p2*/);
            // when palindrome is of even length
            int len2 = expand(s, i/*p1*/, (i + 1)/*p1*/);
            if (len1 > ans) { //selecting maximum length
                ans = len1;
                left = i;
            }
            if (len2 > ans) {
                ans = len2;
                left = i;
            }
        }
        // since l is the center point
        // decreasing l value respectively
        right = left + (ans / 2);
        left = (ans % 2 == 0) ? left - (ans / 2) + 1 : left - (ans / 2);
        String res = "";
        for (int i = left; i <= right; i++) {
            res += s[i];
        }
        return res;
    }

    private static int expand(char[] charString, int p1, int p2) {
        int N = charString.length;
        while (p1 >= 0 && p2 < N && charString[p1] == charString[p2]) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }

    public static void main(String[] args) {
        String A = "aaaabaaa";
        String result = longestPalindrome(A);
        PrintUtils.printString(result);
    }
}
