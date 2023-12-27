package com.scaler.core.java_3_advance_1.dsa_05_bit_manipulations_2.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:55 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Single_Number_III {
    private static int[] solve(int[] A) {
        int v = 0;
        int[] res = new int[2];
        for (int i = 0; i < A.length; i++) {
            v = v ^ A[i];
        }

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(v, i)) {
                count = i;
                break;
            }
        }

        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (checkBit(A[i], count)) {
                ans2 = ans2 ^ A[i];
            } else {
                ans1 = ans1 ^ A[i];
            }
        }
        res[0] = Math.min(ans1, ans2);
        res[1] = Math.max(ans1, ans2);
        return res;
    }

    private static boolean checkBit(int A, int i) {
        if (((A >> i) & 1) == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 4};
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
