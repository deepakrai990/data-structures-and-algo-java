package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_21_hashing_2_geometry_and_string_problems.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 18/02/23 7:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(String A, String B) {
        HashMap<Character, Integer> ahm = new HashMap<>();
        HashMap<Character, Integer> bhm = new HashMap<>();

        if (A.length() != B.length()) return 0;

        for (int i = 0; i < A.length(); i++) {
            ahm.put(A.charAt(i), ahm.getOrDefault(A.charAt(i), 0) + 1);
        }
        for (int i = 0; i < B.length(); i++) {
            bhm.put(B.charAt(i), bhm.getOrDefault(B.charAt(i), 0) + 1);
        }
        for (int i = 0; i < A.length(); i++) {
            int k = ahm.get(A.charAt(i));
            int l = bhm.get(B.charAt(i));
            if (k != l) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String A = "aba";
        String B = "xyx";
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
