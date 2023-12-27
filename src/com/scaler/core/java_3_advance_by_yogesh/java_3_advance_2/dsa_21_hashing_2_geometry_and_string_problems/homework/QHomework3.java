package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_21_hashing_2_geometry_and_string_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 18/02/23 7:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int lengthOfLongestSubstring(String A) {
        int n = A.length();
        Map<Character, Integer> map = new HashMap<>();
        int p = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            int j = map.getOrDefault(ch, -1);
            if (j >= p) {
                p = j + 1;
            }
            int len = i - p + 1;
            maxLen = Math.max(maxLen, len);
            map.put(ch, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String A = "abcabcbb";
        int result = lengthOfLongestSubstring(A);
        PrintUtils.printInt(result);
    }
}
