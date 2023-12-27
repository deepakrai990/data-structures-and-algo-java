package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:43 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sorted_Permutation_Rank {
    private static int findRank(String A) {
        int len = A.length();
        int mod = 1000003;
        long count = 0l;
        long permutationsAfterCur = 1l;
        for (int i = len - 1; i >= 0; i--) {
            char curChar = A.charAt(i);
            int rightCharsLessThanCur = 0;
            for (int j = i + 1; j < len; j++) {
                if (curChar > A.charAt(j)) {
                    rightCharsLessThanCur++;
                }
            }
            if (i < len - 1) {
                permutationsAfterCur = (permutationsAfterCur * (len - i - 1)) % mod;
            }
            count = (count + (permutationsAfterCur * rightCharsLessThanCur) % mod) % mod;
        }
        return (int) (count + 1);
    }

    public static void main(String[] args) {
        String A = "acb";
        int result = findRank(A);
        PrintUtils.printInt(result);
    }
}
