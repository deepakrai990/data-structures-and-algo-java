package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.homework;

/**
 * @created 02/04/23 10:24 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Max_Product_Subarray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxProduct_1(final int[] A) {
        int ans = Integer.MIN_VALUE, curr = 0;
        for (int i = 0; i < A.length; i++) {
            if (curr == 0) {
                curr = 1;
            }
            curr = curr * A[i];
            ans = Math.max(ans, curr);
        }
        int ans2 = Integer.MIN_VALUE;
        curr = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (curr == 0) {
                curr = 1;
            }
            curr = curr * A[i];
            ans2 = Math.max(ans2, curr);
        }
        return Math.max(ans2, ans);
    }
}
