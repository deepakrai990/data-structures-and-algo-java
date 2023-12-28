package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 20/02/23 8:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q6_Is_Dictionary {
    private static int solve(ArrayList<String> A, String B) {
        Map<Character, Integer> iMap = new HashMap<>();
        for (int i = 0; i < B.length(); i++)
            iMap.put(B.charAt(i), i);
        int ans = 1;
        for (int i = 1; i < A.size(); i++) {
            // Get the previous string
            String prev = A.get(i-1);
            // Get the current string
            String curr = A.get(i);
            // Now check every character of both the strings
            if (!isValidStringCombination(prev, curr, iMap)) {
                ans = 0;
                break;
            }

        }
        return ans;
    }
    private static boolean isValidStringCombination(String A, String B, Map<Character, Integer> dictionary) {
        int aIdx = 0, bIdx = 0;
        while (aIdx < A.length() && bIdx < B.length()) {
            char a = A.charAt(aIdx);
            char b = B.charAt(bIdx);
            if (dictionary.get(a) == dictionary.get(b)) {
                aIdx++;
                bIdx++;
            } else if (dictionary.get(a) < dictionary.get(b)) {
                return true;
            } else
                return false;
        }
        if (A.length() > B.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> A = Stream.of("hello", "scaler", "interviewbit")
                .collect(Collectors.toCollection(ArrayList::new));
        String B = "adhbcfegskjlponmirqtxwuvzy";
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
