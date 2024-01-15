package com.scaler.core.java_2_intermediate.dsa_19_string;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 01/10/22 4:03 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Longest_palindromic_substring2 {
    /**
     * Problem: Longest Palindromic Substring
     * Given a string, calculate length of the longest palindromic substring
     * **/
    // Bruteforce Approach
    // Function to check if a string is palindrome
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // Function to find the longest palindromic substring using brute force
    private static String longestPalindromicSubstring(String input) {
        int maxLength = 0;
        String result = "";
        // Generate all possible substrings and check for palindromes
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String currentSubstring = input.substring(i, j);
                if (isPalindrome(currentSubstring) && currentSubstring.length() > maxLength) {
                    maxLength = currentSubstring.length();
                    result = currentSubstring;
                }
            }
        }
        return result;
    }
    // Optimise Approach 1
    // Function to find the longest palindromic substring without dynamic programming
    private static String longestPalindromicSubstring1(String input) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.length(); i++) {
            int len1 = expandAroundCenter(input, i, i);    // Odd length palindrome
            int len2 = expandAroundCenter(input, i, i + 1); // Even length palindrome

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return input.substring(start, end + 1);
    }
    // Helper function to expand around the center and find the length of a palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        String s = "abacab";
        String result = longestPalindromicSubstring(s);
        PrintUtils.print(result);

        result = longestPalindromicSubstring1(s);
        PrintUtils.print(result);
    }

}
