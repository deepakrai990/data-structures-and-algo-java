package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/02/23 11:12 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    private static int solve(int A) {
        int remainder = 0;
        int sum = 0;
        int bitPosition = 1;
        while (A > 0) {
            remainder = A % 2;
            if (remainder == 1) {
                sum = sum + (int) Math.pow(5, bitPosition);
            }
            A = A / 2;
            bitPosition++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int A = 10; // 3;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
