package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

import java.util.Arrays;

/**
 * @created 10/02/23 8:14 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question4 {
    private static int[] solve(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) > 0) {
                index = i;
                break;
            }
        }

        int set_bits = 0;
        int unset_bits = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & (1 << index)) > 0) {
                set_bits ^= A[i];
            } else {
                unset_bits ^= A[i];
            }
        }

        int result[] = new int[2];
        if (set_bits > unset_bits) {
            result[0] = unset_bits;
            result[1] = set_bits;
        } else {
            result[0] = set_bits;
            result[1] = unset_bits;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 4};
        int[] results = solve(A);
        System.out.printf("%s%5s", "Results: ", Arrays.toString(results));
    }
}
