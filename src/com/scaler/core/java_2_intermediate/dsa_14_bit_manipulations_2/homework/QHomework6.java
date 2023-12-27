package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/02/23 11:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework6 {
    private static long reverse(long A) {
        long count = 0;
        for (int i = 0; i < 32; i++) {
            long setOrUnset = A & 1;
            long twosPower = (long) 1<< 31 - i;
            count = count + setOrUnset * twosPower;
            A >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        long A = 3;
        long result = reverse(A);
        PrintUtils.printLong(result);
    }
}
