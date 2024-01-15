package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q3_Negative_Binary_to_Decimal {
    private static int negativeBinaryToDecimal(String binaryString) {
        int decimal = 0;
        int power = 0;
        // Iterate through the binary string from right to left
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (i == 0) { // Subtract Most Significant Bit
                decimal = (int) (decimal - Math.pow(2, power));
            } else if (binaryString.charAt(i) == '1') {
                // If the bit is '1', add 2^power to the decimal value
                decimal += (int) Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }
    public static void main(String[] args) {
        int N = -45;
        String negativeBinary = Integer.toBinaryString(N);
        System.out.println("Binary number of " + N + " is : " + negativeBinary);
        // Convert negative binary to decimal
        int result = negativeBinaryToDecimal(negativeBinary);
        // Print the result
        System.out.println("Decimal number : " + result);
    }
}
