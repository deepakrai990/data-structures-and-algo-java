package com.scaler.core.java_3_advance_2.dsa_18_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Pair_Sum_Equals_to_K {
    /**
     * Given N distinct sorted elements.
     * Check is there exists a pair of (i, j)
     * such that A[i] + A[j] == K, where (i != j)
     * **/
    private static boolean pairSum(int[] A, int K) {
        int N = A.length, P1 = 0, P2 = N - 1;
        while (P1 < P2) {
            if (A[P1] + A[P2] == K) return true;
            else if (A[P1] + A[P2] < K) P1++;
            else P2--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        int K = 17;
        boolean result = pairSum(A, K);
        PrintUtils.print(result);
    }
}
