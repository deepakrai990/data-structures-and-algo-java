package com.scaler.core.java_3_advance_2.dsa_19_hashing_1.homework;

import java.util.HashMap;

/**
 * @created 02/04/23 7:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Check_Palindrome___II {
    private static int solve(String A) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < A.length(); i++) {
            char chr = A.charAt(i);
            if (hm.containsKey(chr)) {
                int val = hm.get(chr);
                if (val % 2 == 0) {
                    hm.remove(chr);
                }
            }
        }
        if (hm.size() > 1) {
            return 0;
        }
        return 1;
    }
}
