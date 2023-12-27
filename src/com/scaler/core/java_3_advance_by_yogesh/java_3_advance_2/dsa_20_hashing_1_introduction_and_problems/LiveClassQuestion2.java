package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 16/02/23 2:45 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Question 2
     * Given an array of size N. Find the length of the longest sequence of consecutive
     * elements.
     * Example
     * int[] A = {100, 4, 3, 6, 10, 20, 11, 5, 101};
     * **/
    private static int longestConsecutive(int[] A) {
        int n = A.length;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        for (int x: set) {
            if (set.contains(x - 1) == false) {
                int chain = 0;
                int y = x + 1;
                while (set.contains(y)) {
                    chain++;
                    y++;
                }
                ans = Math.min(ans, chain);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {100, 4, 3, 6, 10, 20, 11, 5, 101};
        int result = longestConsecutive(A);
        PrintUtils.printInt(result);
    }
}
