package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.assignment;

/**
 * @created 20/09/22 11:54 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question8 {
    private static int decimalToAnyBase(int A, int B) {
        int ans = 0;
        int power = 1;
        while (A > 0) {
            int rem = A % B;
            A = A / B;
            ans += rem * power;
            power = power * 10;
        }
        return ans;
    }

    /**
     * Scaler Solution
     * Approach
     * <p>
     * Hint 1
     * Think about how conversion of one form to another works.
     * Change digit by digit.
     * <p>
     * Solution Approach
     * Step 1:- Divide the decimal number to be converted by the value of the new base.
     * Step 2:- Get the remainder from Step 1 as the rightmost digit
     * (the least significant digit) of new base number.
     * Step 3:− Divide the quotient of the previous divide by the new base.
     * Step 4 − Record the remainder from Step 3 as the next digit
     * (to the left) of the new base number.
     **/
    private static int decimalToAnyBase1(int A, int B) {
        int ans = 0;
        int pow = 1;
        while (A > 0) {
            int digit = A % B;
            A /= B;
            ans += digit * pow;
            pow *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 3;
        int result = decimalToAnyBase(A, B);
        System.out.println("Result : " + result);
        A = 634;
        B = 8;
        result = decimalToAnyBase1(A, B);
        System.out.println("Result : " + result);
    }
}
