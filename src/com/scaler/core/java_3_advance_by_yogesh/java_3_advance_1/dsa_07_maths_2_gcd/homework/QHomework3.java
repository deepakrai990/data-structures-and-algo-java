package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_07_maths_2_gcd.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 18/01/23 10:57 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int[] solve(int[] A) {
        int n = A.length;
        int interval = (int) Math.sqrt(n);
        int[] res = new int[interval];
        int max = 0;
        int count = 0, k = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] > max) max = A[i];
            count++;
            if(count == interval) {
                res[k++] = max;
                max = 0;
                count = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 8, 2, 2, 2, 10};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
