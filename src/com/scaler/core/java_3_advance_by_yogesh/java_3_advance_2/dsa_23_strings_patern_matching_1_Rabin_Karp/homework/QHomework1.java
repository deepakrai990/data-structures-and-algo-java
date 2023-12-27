package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_23_strings_patern_matching_1_Rabin_Karp.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 21/02/23 10:23 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int A, String B) {
        int N = B.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (hm.containsKey(B.charAt(i))) {
                hm.put(B.charAt(i), hm.get(B.charAt(i)) + 1);
            } else {
                hm.put(B.charAt(i), 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(B.charAt(i))) {
                if (hm.get(B.charAt(i)) % A == 0) {
                    hm.remove(B.charAt(i));
                } else {
                    return -1;
                }
            }
        }
        return 1;
    }

    private static int solve1(int A, String B) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < B.length(); i++) {
            if (mp.get(B.charAt(i)) % A != 0) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int A = 2;
        String B = "bbaabb";
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve1(A, B);
        PrintUtils.printInt(result);
    }
}
