package com.scaler.core.java_3_advance_4.dsa_48_dynamic_programming_5;

import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 19/12/23
 * @project scaler_course_code
 */
public class Q1_Longest_Common_Subsequence_3 {
    // Function to find the length of the longest common subsequence
    private static int longestCommonSubsequence(String S1, String S2) {
        // Create a memoization HashMap to store computed results
        HashMap<String, Integer> memoization = new HashMap<>();
        // Start the recursion from the end of both strings
        return lcsRecursive(S1, S2, S1.length() - 1, S2.length() - 1, memoization);
    }
    // Recursive helper function with memoization
    private static int lcsRecursive(String S1, String S2, int i, int j, HashMap<String, Integer> memoization) {
        // Base case
        if (i < 0 || j < 0) {
            return 0;
        }
        // Create a unique key for the current state
        String key = i + ":" + j;
        // Check if the result is already computed
        if (memoization.containsKey(key)) {
            return memoization.get(key);
        }
        // If the characters match, include them in the common subsequence
        if (S1.charAt(i) == S2.charAt(j)) {
            int result = 1 + lcsRecursive(S1, S2, i - 1, j - 1, memoization);
            memoization.put(key, result);
            return result;
        } else {
            // Characters do not match, explore both possibilities
            int result = Math.max(
                    lcsRecursive(S1, S2, i - 1, j, memoization),
                    lcsRecursive(S1, S2, i, j - 1, memoization)
            );
            // Update the memoization HashMap
            memoization.put(key, result);
            return result;
        }
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCAB";

        int length = longestCommonSubsequence(S1, S2);

        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
