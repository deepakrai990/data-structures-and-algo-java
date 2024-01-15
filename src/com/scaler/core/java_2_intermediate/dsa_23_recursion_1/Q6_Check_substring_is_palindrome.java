package com.scaler.core.java_2_intermediate.dsa_23_recursion_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q6_Check_substring_is_palindrome {
    /**
     * Problem: Given a substring, check if its palindrome or not
     * **/
    private static boolean isPalindrome(char[] chars, int start, int end) {
        // Base case
        if (start > end) {
            return true;
        }
        return chars[start] == chars[end] && isPalindrome(chars, start+ 1, end  - 1);
    }
    // Recursive function to check if a char array substring is a palindrome
    private static boolean isPalindromeSubstring(char[] charArray, int start, int end) {
        // Base case: an empty char array or a char array with one element is a palindrome
        if (start >= end) {
            return true;
        }

        // Check if the first and last characters are the same
        if (charArray[start] == charArray[end]) {
            // Recursive call to check the substring excluding the first and last characters
            return isPalindromeSubstring(charArray, start + 1, end - 1);
        } else {
            // If the first and last characters are not the same, it's not a palindrome
            return false;
        }
    }
    public static void main(String[] args) {
        char[] chars = "gooddad".toCharArray();
        int start = 4;
        int end = 6;

        boolean isPalindrome = isPalindrome(chars, start, end);
        System.out.println("Is the given char array a palindrome : " + isPalindrome);

        isPalindrome = isPalindromeSubstring(chars, start, end);
        System.out.println("Is the given char array a palindrome : " + isPalindrome);
    }
}
