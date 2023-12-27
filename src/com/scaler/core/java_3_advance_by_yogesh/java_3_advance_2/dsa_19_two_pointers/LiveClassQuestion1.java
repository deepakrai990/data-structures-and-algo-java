package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 14/02/23 11:07 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Question 1. Given array A[N] distinct sorted elements.
     * Check of there exists a pair(i, j), such that A[i] + A[j] = K
     * and i != j.
     * Example
     * int[] A = {3, 7, 8, 12, 19};
     * int K = 15;
     **/
    private static boolean checkPairSum(int[] A, int K) {
        int n = A.length;
        // two pointer technique
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int sum = A[p1] + A[p2];
            if (sum == K) return true;
            else if (sum > K) p2--; // decrement sum, p2--
            else p1++; // increment sum p1++
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 8, 12, 19};
        int K = 15;
        boolean result = checkPairSum(A, K);
        PrintUtils.printBool(result);
    }

}
