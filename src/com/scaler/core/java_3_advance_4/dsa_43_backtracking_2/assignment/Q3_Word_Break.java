package com.scaler.core.java_3_advance_4.dsa_43_backtracking_2.assignment;

import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 11:00 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Word_Break {
    Boolean[] dp;

    private int wordBreak(String A, String[] B) {
        dp = new Boolean[A.length()];
        Set<String> set = new HashSet<>();
        for (String words : B) {
            set.add(words);
        }
        if (set.contains(A))
            return 1;
        return helper(0, 1, A, set) == true ? 1 : 0;
    }

    private boolean helper(int startingIndex, int endingIndex, String A, Set<String> set) {
        if (startingIndex == A.length())
            return true;
        if (dp[startingIndex] != null)
            return dp[startingIndex];
        for (int i = endingIndex; i <= A.length(); i++) {
            String word = A.substring(startingIndex, i);
            if (set.contains(word) && helper(i, i + 1, A, set))
                return dp[startingIndex] = true;
        }
        return dp[startingIndex] = false;
    }
}
