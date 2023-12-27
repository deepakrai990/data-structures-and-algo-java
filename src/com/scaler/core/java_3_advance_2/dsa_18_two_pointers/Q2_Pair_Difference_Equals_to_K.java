package com.scaler.core.java_3_advance_2.dsa_18_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/10/23 7:16 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Pair_Difference_Equals_to_K {
    /**
     * Given N distinct sorted elements, check if there exists a pair (i, j)
     * such A[j] - A[i] K, where (K > 0) and (i != j)
     * **/
    private static boolean pairDiff(int[] A, int K) {
        int P1 = 0, P2 = 1;
        while (P2 < A.length) {
            if (A[P2] - A[P1] == K) return true;
            else if (A[P2] - A[P1] > K) {
                P1++;
                if (P1 == P2) P2++;
            } else {
                P2++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        int K = 5;
        boolean result = pairDiff(A, K);
        PrintUtils.print(result);
    }
}
