package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 15/02/23 8:42 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given sorted array A[n] elements.
     * Check if there exist a pair(i, j) such that A[j] - A[i] = K, and
     * i != j & K >= 0.
     * Example
     * int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
     * int K = 5;
     * <p></p>
     * T.C: O(N)
     * S.C: O(1)
     * <p></p>
     * Case: 1
     * p1 = 0, p2 = n - 1
     * Ambiguity, we can't discord any of the pointer
     * <p></p>
     * Case: 2
     * mid = n / 2
     * p1 = mid, p2 = mid + 1
     * Ambiguity, we can't decide
     * <p></p>
     * Case: 3
     * p1 = 0, p2 = 1
     * It will work.
     * <p></p>
     * Case: 4
     * p1 = n - 1, p2 n - 2
     * It will work.
     **/
    private static boolean checkPairDiff(int[] A, int K) {
        int n = A.length;
        // tow pointer technique for check pair difference
        int p1 = 0, p2 = 1;
        while (p1 < n && p2 < n) {
            int diff = A[p2] - A[p1];
            if (diff == K) return true;
            else if (diff > K) {
                p1++;
                if (p1 == p2) p2++;
            } else p2++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        int K = 5;
        boolean result = checkPairDiff(A, K);
        PrintUtils.printBool(result);
    }
}
