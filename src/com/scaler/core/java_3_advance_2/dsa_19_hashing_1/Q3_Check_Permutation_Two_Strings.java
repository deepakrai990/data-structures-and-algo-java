package com.scaler.core.java_3_advance_2.dsa_19_hashing_1;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 04/10/23 6:59 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Check_Permutation_Two_Strings {
    /**
     * Given two Strings s1 and s2 of equal length.
     * Check is they are permutation of each other.
     * **/
    private static boolean arePermutations(String s1, String s2) {
        // Check id the strings have the same length
        if (s1.length() != s2.length()) return false;
        int[] charCount = new int[256]; // Assuming ASCII characters
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            charCount[s2.charAt(i)]--;
        }
        for (int count: charCount) {
            if (count != 0) return false;
        }
        return true;
    }
    private static boolean arePermutationsWithHashMap(String s1, String s2) {
        // Check id the strings have the same length
        if (s1.length() != s2.length()) return false;
        // Create a HashMap to count character occurrences in s1
        Map<Character, Integer> charCount = new HashMap<>();
        // Increment character counts for s1
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        // Decrement character count for s2
        for (char c: s2.toCharArray()) {
            if (!charCount.containsKey(c)) return false;
            int count = charCount.get(c);
            if (count == 1) charCount.remove(c); // Remove character if count reaches zero
            else charCount.put(c, count - 1);
        }
        // If the HashMap is empty, the strings are permutations of each other
        return charCount.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "anat";
        String s2 = "tana";
        boolean result = arePermutations(s1, s2);
        PrintUtils.print(result);
        PrintUtils.printNewLine();
        result = arePermutationsWithHashMap(s1, s2);
        PrintUtils.print(result);
    }
}
