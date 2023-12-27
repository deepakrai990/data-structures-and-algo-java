package com.scaler.interview.string;

/**
 * @created 27/07/23 11:33 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q_2_LongestPalindromicStringInS {
    public static String longestPalindromeOptimise(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // Initialize a 2D boolean array to track palindromic substrings
        boolean[][] dp = new boolean[n][n];

        // Initialize variables to keep track of the longest palindromic substring found
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for palindromic substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromic substrings of length >= 3
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; // End index of the substring
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        // Extract the longest palindromic substring from the 'start' and 'maxLength'
        return s.substring(start, start + maxLength);
    }

    // Function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Function to find the longest palindromic substring using brute force
    public static String longestPalindrome(String s) {
        int n = s.length();
        String longestPalindrome = "";

        // Brute-force approach with two nested loops
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (isPalindrome(s, start, end)) {
                    int currentLength = end - start + 1;
                    if (currentLength > longestPalindrome.length()) {
                        longestPalindrome = s.substring(start, end + 1);
                    }
                }
            }
        }

        return longestPalindrome;
    }

    public static String longestPalindrome_1(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int currentLength = Math.max(odd, even);
            if (currentLength > end - start) {
                /**
                 * calculating starting length because we are expanding left and right so
                 * dividing (currentLength - 1) / 2 and remaining subtracting from i
                 ***/
                start = i - (currentLength - 1) / 2;
                /**
                 * calculating end length by dividing currentLength / 2 and remaining
                 * adding to i
                 * **/
                end = i + currentLength / 2;
            }
        }
        return s.substring(start, end + 1);

    }
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // Example usage:
    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindromeOptimise(input);
        System.out.println("Longest palindromic substring: " + longestPalindrome);
        longestPalindrome = longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + longestPalindrome);
        longestPalindrome = longestPalindrome_1(input);
        System.out.println("Longest palindromic substring: " + longestPalindrome);
    }
}
