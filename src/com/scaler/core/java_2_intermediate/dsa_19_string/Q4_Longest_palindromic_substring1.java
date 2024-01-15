package com.scaler.core.java_2_intermediate.dsa_19_string;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q4_Longest_palindromic_substring1 {
    /**
     * Problem: Longest Palindromic Substring
     * Given a string, calculate length of the longest palindromic substring
     * **/
    // Bruteforce Approach
    // Function to check if a string is palindrome
    private static boolean isPalindrome(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // Function to find the length of the longest palindromic substring using brute force
    private static int longestPalindromicSubstring(char[] input) {
        int maxLength = 0;

        // Generate all possible substrings and check for palindromes
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (isPalindrome(input, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
    // Optimise Approach 1
    private static int longestPalindrome(char[] s) {
        int N = s.length;
        int ans = 0;
        // for add palindrome
        for(int i = 0; i < N; i++) {
            // center: s[i]
            int p1 = i, p2 = i;
            ans = Math.max(ans, expand(s, p1, p2));
        }
        // for even palindrome
        for(int i = 0; i < N; i++) {
            // center : s[i], s[i + 1]
            int p1 = i, p2 = i + 1;
            ans = Math.max(ans, expand(s, p1, p2));
        }
        return ans;
    }
    private static int expand(char[] charString, int p1, int p2) {
        int N = charString.length;
        while(p1 >= 0 && p2 < N && charString[p1] == charString[p2]) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }
    // Optimise Approach 2
    // Function to find the length of the longest palindromic substring without dynamic programming
    private static int longestPalindromicSubstring1(char[] input) {
        int maxLength = 0;
        for (int i = 0; i < input.length; i++) {
            int len1 = expandAroundCenter(input, i, i);    // Odd length palindrome
            int len2 = expandAroundCenter(input, i, i + 1); // Even length palindrome

            int len = Math.max(len1, len2);
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }
    // Helper function to expand around the center and find the length of a palindrome
    private static int expandAroundCenter(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        String s = "abacab";
        int result = longestPalindromicSubstring(s.toCharArray());
        PrintUtils.print(result);

        result = longestPalindrome(s.toCharArray());
        PrintUtils.print(result);

        result = longestPalindromicSubstring1(s.toCharArray());
        PrintUtils.print(result);
    }
}
