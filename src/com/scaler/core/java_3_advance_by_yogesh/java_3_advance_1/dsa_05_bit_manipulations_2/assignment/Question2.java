package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_05_bit_manipulations_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 10/02/23 9:54 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question2 {
    private static int solve(int[] A) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            // count no of set bits
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (checkBit(A[j], i)) {
                    count++;
                }
            }
            if (count >= 2) {
                // We can pick a pair & make your answer as set for that bit
                ans = ans + (1 << i);
                // Discard element where i th bit is unset
                for (int j = 0; j < A.length; j++) {
                    if (!checkBit(A[j], i)) {
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean checkBit(int A, int i) {
        if (((A >> i) & 1) == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] A = {38, 44, 84, 12};
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
