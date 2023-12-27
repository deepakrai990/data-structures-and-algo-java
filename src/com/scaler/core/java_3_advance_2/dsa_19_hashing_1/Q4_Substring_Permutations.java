package com.scaler.core.java_3_advance_2.dsa_19_hashing_1;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 04/10/23 7:17 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Substring_Permutations {
    /**
     * Count the number of sub-string of B which are permutations of A
     * **/
    private static int countPermutationSubstrings(String A, String B) {
        // Create frequency maps for characters in strings A and B
        Map<Character, Integer> charCountA = new HashMap<>();
        Map<Character, Integer> charCountB = new HashMap<>();
        int count = 0, left = 0, right = 0;
        // Initialize the frequency map for string A
        for (char c: A.toCharArray())
            charCountA.put(c, charCountA.getOrDefault(c, 0) + 1);
        // Slide the window over string B
        while (right < B.length()) {
            char currentChar = B.charAt(right);
            // Update the frequency map for string B
            charCountB.put(currentChar, charCountB.getOrDefault(currentChar, 0) + 1);
            // Shrink the window if it's too large
            while (charCountB.get(currentChar) > charCountA.getOrDefault(currentChar, 0)) {
                char leftChar = B.charAt(left);
                charCountB.put(leftChar, charCountB.get(leftChar) - 1);
                left++;
            }
            // Check if the current window is a permutation of A
            if (right - left + 1 == A.length()) {
                count++;
            }
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        String A = "abc";
        String B = "cbabcacbacba";
        int result = countPermutationSubstrings(A, B);
        PrintUtils.print(result);
    }
}
