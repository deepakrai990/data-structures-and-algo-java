package com.scaler.core.java_2_intermediate.dsa_19_string;

/**
 * @author Deepak Kumar Rai
 * @created 07/01/24
 * @project scaler_course_code
 */
public class Q3_Given_substring_is_palindrome_or_not {
    /**
     * Problem: Check if a given substring is palindrome or not.
     * **/
    private static boolean isPalindrome(char[] chars, int start, int end) {
        // Check is substring [start end] is a palindrome
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'n', 'a', 'm', 'a', 'd', 'a', 'm', 's', 'p', 'e'};
        int start = 3, end = 7; // [3 7]

        boolean result = isPalindrome(chars, start, end);
        System.out.println("Is palindrome from [" + start + " to " + end +"] : " + result);

        start = 8;
        end = 10;
        result = isPalindrome(chars, start, end); // [8 10]
        System.out.println("Is palindrome from [" + start + " to " + end +"] : " + result);

        start = 0;
        end = 2;
        result = isPalindrome(chars, start, end);
        System.out.println("Is palindrome from [" + start + " to " + end +"] : " + result);

    }
}
