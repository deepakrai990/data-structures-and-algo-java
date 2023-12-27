package com.scaler.core.java_3_advance_2.dsa_18_two_pointers.homework;

/**
 * @created 02/04/23 7:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Minimize_the_absolute_difference {
    private static int solve(int[] A, int[] B, int[] C) {
        int p1 = 0, p2 = 0, p3 = 0;
        int p = A.length, q = B.length, r = C.length;
        int minn = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        while (p1 < p && p2 < q && p3 < r) {
            minn = Math.min(A[p1], Math.min(B[p2], C[p3]));
            maxx = Math.max(A[p1], Math.max(B[p2], C[p3]));
            int diff = Math.abs(maxx - minn);
            res = Math.min(diff, res);
            if (minn == A[p1]) {
                p1++;
            } else if (minn == B[p2]) {
                p2++;
            } else {
                p3++;
            }
        }
        return res;
    }
}
