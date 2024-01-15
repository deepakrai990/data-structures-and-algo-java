package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 27/12/23
 * @project scaler_course_code
 */
public class Q1_Binary_to_Decimal {
    private static int binaryToDecimal(String binaryNumber) {
        int length = binaryNumber.length();
        int decimal = 0;
        int powerOf2 = 0;
        // Start from the rightmost digit
        for (int i = length - 1; i >= 0; i--) {
            // Convert the character to an integer (either 0 or 1)
            int binaryDigit = Character.getNumericValue(binaryNumber.charAt(i));
            // Multiply the binary digit by the corresponding power of 2 and accumulate

            decimal += binaryDigit * (int) Math.pow(2, powerOf2);
            System.out.println(binaryDigit + " X " + " 2 ^ " + powerOf2 + " = " +
                    binaryDigit * (int) Math.pow(2, powerOf2));
            // Move to the next power of 2
            powerOf2++;
        }
        return decimal;
    }
    public static void main(String[] args) {
        String binaryNumber = "10110";
        int decimalEquivalent = binaryToDecimal(binaryNumber);
        System.out.println("Binary: " + binaryNumber);
        System.out.println("Decimal Equivalent: " + decimalEquivalent);
    }
}
