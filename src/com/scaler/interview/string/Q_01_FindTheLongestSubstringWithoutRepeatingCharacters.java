package com.scaler.interview.string;

import java.util.HashSet;

/**
 * @created 27/07/23 11:21 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q_01_FindTheLongestSubstringWithoutRepeatingCharacters {
    // Function to find the longest substring without repeating characters
    public static String findLongestSubstringWithoutRepeatingCharsOptimise(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int maxStart = 0;
        HashSet<Character> uniqueChars = new HashSet<>();
        while (end < n) {
            char currentChar = s.charAt(end);
            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                int currentLength = end - start + 1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = start;
                }
                end++;
            } else {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    // Function to check if a substring has all unique characters

    public static String findLongestSubstringWithoutRepeatingChars(String s) {
        int n = s.length();
        int maxLength = 0;
        String longestSubstring = "";

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (hasUniqueCharacters(s, start, end)) {
                    int currentLength = end - start + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        longestSubstring = s.substring(start, end + 1);
                    }
                }
            }
        }
        return longestSubstring;
    }
    private static boolean hasUniqueCharacters(String s, int start, int end) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char currentChar = s.charAt(i);
            if (uniqueChars.contains(currentChar)) {
                return false;
            }
            uniqueChars.add(currentChar);
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "abcabcbb";
        String longestSubstring = findLongestSubstringWithoutRepeatingCharsOptimise(input);
        System.out.println("Longest substring without repeating characters: " + longestSubstring);
        longestSubstring = findLongestSubstringWithoutRepeatingChars(input);
        System.out.println("Longest substring without repeating characters: " + longestSubstring);
    }
}
