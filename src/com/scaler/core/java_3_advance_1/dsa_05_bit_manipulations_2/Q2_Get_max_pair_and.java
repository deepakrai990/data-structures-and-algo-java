package com.scaler.core.java_3_advance_1.dsa_05_bit_manipulations_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Q2_Get_max_pair_and {
    /**
     * Problem: Given an array A[N]. Choose two indices (i, j) such that (i != j) and
     * get max pf Ai & Aj. (Bitwise & (and))
     * **/
    private static int maxPairAnd(int[] A) {
        int N = A.length;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            // Get the number of elements whose ith bit is 1 (set)
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (checkBit(A[j], i)) {
                    count++;
                }
            }
            if (count >= 2) {
                ans = ans + (1 << i); // (2)^i
                // Now discard unwanted elements
                for (int j = 0; j < N; j++) {
                    if (!checkBit(A[j], i)) {
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    private static boolean checkBit(int N, int I) {
        return (N | (1 << I)) == N;
    }
    public static void main(String[] args) {
        int[] A = {21, 18, 24, 17, 16};

        int result = maxPairAnd(A);
        PrintUtils.print(result);
    }
}
