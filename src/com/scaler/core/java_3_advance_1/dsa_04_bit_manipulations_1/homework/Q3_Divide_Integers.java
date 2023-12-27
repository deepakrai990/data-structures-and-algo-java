package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:00 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Divide_Integers {
    private static int divide(int A, int B) {
        //method
        // A/B => 125/5 ==>
        // 125 = 5*25 ==> 5 * ( 2^4 * (1) + 2^3 * (1) + 2^2* (0) + 2^1 * (0)+ 2^0 * (1) );
        boolean sign = (A < 0) ^ (B < 0);
        long answer = 0L;
        long tempA = Math.abs(A * 1L);
        long tempB = Math.abs(B * 1L);

        for (int i = 31; i >= 0; i--) {
            long power = (long) tempB << i;
            while (power <= tempA) {
                tempA -= power;
                answer += (1L << i);
            }
        }
        if (answer >= Integer.MAX_VALUE)
            return (sign ? -Integer.MIN_VALUE : Integer.MAX_VALUE);
        if (sign)
            return (int) answer * -1;
        return (int) answer;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int result = divide(A, B);
        PrintUtils.print(result);
    }
}
