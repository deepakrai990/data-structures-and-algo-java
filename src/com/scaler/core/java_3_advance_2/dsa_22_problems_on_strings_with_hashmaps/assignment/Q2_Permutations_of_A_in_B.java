package com.scaler.core.java_3_advance_2.dsa_22_problems_on_strings_with_hashmaps.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 02/04/23 6:57 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Permutations_of_A_in_B {
    private static int solve(String A, String B) {
        //intuition is counting characters in every substring window
        //make freq-map of String A
        int m = A.length();
        int n = B.length();
        //edge case
        if (n < m) return 0;
        int count = 0;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (char c : A.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        while (r < n) {
            if (mapB.isEmpty()) {
                l = r;
            }
            char c = B.charAt(r);
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
            //if the character is not present in A, then substring can’t be formed
            if (!mapA.containsKey(c)) {
                mapB = new HashMap<>();
            }
            //handling if the frequency of character in substring of B is higher than frequency of character in string A
            else if (mapA.containsKey(c) && mapA.get(c) < mapB.get(c)) {
                while (mapB.get(c) > mapA.get(c)) {
                    mapB.put(B.charAt(l), mapB.get(B.charAt(l)) - 1);
                    if (mapB.getOrDefault(B.charAt(l), 0) <= 0)
                        mapB.remove(B.charAt(l));
                    l++;
                }
            }
            if (mapA.equals(mapB))
                count++;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "abcbacabc";
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
