package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_21_hashing_2_geometry_and_string_problems.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 18/02/23 7:05 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static String minWindow(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        char[] b = B.toCharArray();
        for (char value : b) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE;
        int t = map.size();
        int l = 0;
        int r = 0;
        StringBuilder str = new StringBuilder();
        while (r < A.length()) {
            if (map.containsKey(A.charAt(r))) {
                if (map.get(A.charAt(r)) == 1) {
                    --t;
                }
                map.put(A.charAt(r), map.get(A.charAt(r)) - 1);
            }
            while (t == 0) {
                if (resLen > (r - l + 1)) {
                    str.delete(0, str.length());
                    str.append(A, l, l + (r - l + 1));
                    resLen = str.length();
                }
                if (map.containsKey(A.charAt(l))) {
                    int val = map.get(A.charAt(l));
                    if (val == 0) {
                        ++t;
                    }
                    map.put(A.charAt(l), val + 1);
                }
                l++;
            }
            r++;
        }
        return str.toString();
    }
    private static String minWindow1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if (len2 > len1) return "";
        int[] freq = new int[128];
        int k = 0;

        for (int i = 0; i < len2; i++) {
            int charVal = b.charAt(i) - '0';
            if (freq[charVal - '0'] == 0) k++;
            freq[charVal]++;
        }


        int left = 0;
        int leftAns = 0;
        int rightAns = 10000000;

        for (int right = 0; right < len1; right++) {
            char c = a.charAt(right);
            freq[c - '0']--;
            if (freq[c - '0'] == 0) k--;

            while (k == 0) {

                while (rightAns - leftAns + 1 > right - left + 1) {
                    rightAns = right;
                    leftAns = left;
                }
                int charVal = b.charAt(left) - '0';
                if (freq[charVal] == 0) k++;
                freq[charVal]++;
                left++;

            }

        }

        if (rightAns > len1 - 1) return "";
        return a.substring(leftAns, rightAns + 1);
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        String result = minWindow(A, B);
        PrintUtils.printString(result);
    }
}
