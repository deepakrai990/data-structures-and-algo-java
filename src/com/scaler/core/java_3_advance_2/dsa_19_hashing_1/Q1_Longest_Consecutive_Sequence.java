package com.scaler.core.java_3_advance_2.dsa_19_hashing_1;

import com.scaler.core.utils.PrintUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Longest_Consecutive_Sequence {
    /**
     * Given A[N]. Find the length of the longest sequence which can be
     * rearranged in strictly increasing order by 1.
     * **/
    private static int longestSeq(int[] A) {
        Set<Integer> hs = new HashSet<>();
        for (int a: A) hs.add(a);
        int N = A.length, result = 0;
        for (int i = 0; i < N; i++) {
            int x = A[i];
            if (!hs.contains(x - 1)) {
                int length = 0, y = x;
                while (hs.contains(y)) {
                    length++; y++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {-1, 8, 5, 3, 10, 2, 4, 9};
        int result = longestSeq(A);
        PrintUtils.print(result);
    }
}
