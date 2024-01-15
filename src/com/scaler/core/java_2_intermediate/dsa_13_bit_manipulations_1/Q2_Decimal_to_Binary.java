package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q2_Decimal_to_Binary {
    private static String decimalToBinary(int decimalNumber) {
        StringBuilder binary = new StringBuilder();
        // Continue until the decimal number is greater than 0
        while (decimalNumber > 0) {
            // Record the remainder (LSB)
            int remainder = decimalNumber % 2;
            // Add the remainder to the beginning of the binary representation
            binary.insert(0, remainder);
            // Divide the decimal number by 2
            System.out.println(2 + " | " + decimalNumber + " | " + remainder);
            System.out.println("-------------");
            decimalNumber /= 2;
        }

        // If the binary representation is empty, the decimal number was 0
        // In that case, return "0"
        return binary.length() > 0 ? binary.toString() : "0";
    }

    public static void main(String[] args) {
        int decimalNumber = 20;
        String binaryEquivalent = decimalToBinary(decimalNumber);
        System.out.println("Decimal: " + decimalNumber);
        System.out.println("Binary Equivalent: " + binaryEquivalent);
    }
}
