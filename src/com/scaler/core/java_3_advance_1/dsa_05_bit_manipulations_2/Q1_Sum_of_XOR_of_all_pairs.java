package com.scaler.core.java_3_advance_1.dsa_05_bit_manipulations_2;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_of_XOR_of_all_pairs {
    /**
     * Problem: Given an array A[N]. Calculate the sum of XOR of all pairs.
     * **/
    private static int xorPairSum(int[] A) {
        int N = A.length;
        int sum = 0;
        for (int i = 0; i <= 30; i++) {
            // for every bit position (i), get count of set & unset bits
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (checkBit(A[j], i)) {
                    count++;
                }
            }
            int pairs = count * (N - count);
            sum = sum + pairs * (1 << i);
        }
        return 2 * sum;
    }
    private static boolean checkBit(int N, int I) {
        return (N | (1 << I)) == N;
    }
    public static void main(String[] args) {
        int[] A = {3, 5, 6, 8, 2};

        int result = xorPairSum(A);
        PrintUtils.print(result);
    }
}
