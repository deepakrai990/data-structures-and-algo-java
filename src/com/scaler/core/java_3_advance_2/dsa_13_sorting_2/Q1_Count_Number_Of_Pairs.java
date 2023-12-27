package com.scaler.core.java_3_advance_2.dsa_13_sorting_2;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 23/09/23 10:08 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Count_Number_Of_Pairs {
    /**
     * Question: Given two array A[N] & B[M], count number of pairs (i, j)
     * such that A[i] > B[j].
     * **/
    // Bruteforce Approach
    private static int countPairsBruteForce(int[] A, int[] B) {
        int count = 0, N = A.length, M = B.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i] > B[j]) count++;
            }
        }
        return count;
    }

    // Optimise Approach
    private static int countPairsOptimise(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0, N = A.length, M = B.length, P1 =0, P2 = 0;
        while (P1 < N && P2 < M) {
            if (A[P1] <= B[P2]) P1++;
            else {
                count = count + (N - P1);
                P2++;
            }
        }
        return count;
    }
    /**
     * T.C: nlogn + mlogn + (n + m)
     * S.C: O(1)
     * **/
    public static void main(String[] args) {
        int[] A = {7, 3, 5};
        int[] B = {2, 0, 6};
        int result = countPairsBruteForce(A, B);
        PrintUtils.print(result);
        PrintUtils.printNewLine();
        result = countPairsOptimise(A, B);
        PrintUtils.print(result);
    }
}
