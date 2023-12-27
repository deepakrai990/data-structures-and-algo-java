package com.scaler.core.java_2_intermediate.dsa_29_subsequences_subsets.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 05/03/23 6:06 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_SUBARRAY_OR {
    private static int solve(int[] A) {
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long subArray = 0;
            long bitzero = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) == 0) {
                    bitzero += 1;
                }
                if ((A[j] & (1 << i)) > 0 || j == n - 1) {
                    subArray += (bitzero * (bitzero + 1)) / 2;
                    bitzero = 0;
                }
            }
            ans += (tot_subArray - subArray) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = {7, 8, 9, 10};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
