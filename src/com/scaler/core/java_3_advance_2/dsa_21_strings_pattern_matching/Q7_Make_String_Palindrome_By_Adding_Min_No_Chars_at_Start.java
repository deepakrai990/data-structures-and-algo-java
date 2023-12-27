package com.scaler.core.java_3_advance_2.dsa_21_strings_pattern_matching;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 08/10/23 11:08 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q7_Make_String_Palindrome_By_Adding_Min_No_Chars_at_Start {
    /**
     * Given a string S[N] calculate the minimum number of chars to add
     * at start to make entire string palindrome
     * **/
    /**
     * Solution
     * 1. Make s + "$" + reverse(s) now the total length of string is N + 1 + N = 2N + 1
     * 2. Find LPS[] of above s.
     * 3. Answer = N - LPS[2N] (last value)
     * **/
    private static int minCharsToAddToMakePalindrome(String s) {
        int N = s.length();
        s = s + "$" + new StringBuilder(s).reverse();
        // lps array contains the longest prefix, which is also a suffix
        int[] lps = computeLPS(s);
        return Math.max(N - lps[2 * N], 0);
    }
    private static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix (LPS)
        lps[0] = 0; // The LPS value for the first character is always 0
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++; lps[i] = len; i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Move the len back to the previous LPS value
                } else {
                    lps[i] = 0; // No matching prefix found, set LPS to 0 and move to the next character
                    i++;
                }
            }
        }
        return lps;
    }

    // Using DP (Dynamic Programming)
    private static int minCharsToAddToMakePalindrome_1(String s) {
        int n = s.length();
        // Create a reversed string
        String reversed = new StringBuilder(s).reverse().toString();
        // Compute the Longest Common Subsequence (LCS) between s and its reverse
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // Minimum characters to add at the start = (n - LCS length)
        return n - dp[n][n];
    }

    public static void main(String[] args) {
        String s = "abacd";
        int result = minCharsToAddToMakePalindrome(s);
        PrintUtils.print(result);
        PrintUtils.printNewLine();
        result = minCharsToAddToMakePalindrome_1(s);
        PrintUtils.print(result);
    }
}
