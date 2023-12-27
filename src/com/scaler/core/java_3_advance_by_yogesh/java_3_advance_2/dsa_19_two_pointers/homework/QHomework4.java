package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_19_two_pointers.homework;

/**
 * @created 15/02/23 11:18 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int temp = -1, ans = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            int diff1 = Math.abs(A[p1] - B[p2]);
            int diff2 = Math.abs(B[p2] - C[p3]);
            int diff3 = Math.abs(C[p3] - A[p1]);
            temp = Math.max(Math.max(diff1, diff2), diff3);
            //target that difference which is contributing to maximum diff
            if (diff1 == temp) {
                if (A[p1] < B[p2]) p1++;
                else p2++;
            } else if (diff2 == temp) {
                if (B[p2] < C[p3]) p2++;
                else p3++;
            } else {
                if (A[p1] < C[p3]) p1++;
                else p3++;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
