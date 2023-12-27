package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_20_hashing_1_introduction_and_problems.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.HashSet;

/**
 * @created 16/02/23 10:10 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question1 {
    private static int longestConsecutive(final int[] A) {
        // Create Hashset
        HashSet<Integer> hs = new HashSet<>();
        // Insert all elements to Hashset
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!hs.contains(A[i] - 1)) {
                int count = 0;
                int val = A[i];
                while (hs.contains(val)) {
                    count++;
                    val++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(A);
        PrintUtils.printInt(result);
    }
}
