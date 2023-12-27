package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_05_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 9:52 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework1 {
    private static int solve(int A) {
        int msb = 0;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if (checkBit(A, i)) {
                msb = Math.max(msb, i);
            } else if (msb != 0) {
                ans += 1 << i;
            }
        }
        ans += 1 << (msb + 1);
        return ans;
    }

    private static boolean checkBit(int A, int i) {
        if (((A >> i) & 1) == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
