package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_05_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 9:53 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework3 {
    private static int solve(int[] A) {
        long ans = 0l;
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        for (int i = 0; i < 32; i++) {
            long anszero = 0l;
            long cnt = 0l;
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) != 1) {
                    cnt++;
                } else {
                    anszero += ((cnt * (cnt + 1)) / 2);
                    cnt = 0;
                }
            }
            anszero += ((cnt * (cnt + 1)) / 2);
            anszero = (tot_subArray - anszero);
            ans = (ans + (anszero * (1 << i))) % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
