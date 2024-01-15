package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

import com.sun.xml.internal.ws.util.ASCIIUtility;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q3_Addition_of_binary_numbers2 {
    // Function to perform binary addition
    private static String performBinaryAddition(String binary1, String binary2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;

        for (int i = binary1.length() - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(binary1.charAt(i));
            int bit2 = Character.getNumericValue(binary2.charAt(i));

            // Calculate the sum and carry
            int resultBit = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (carry & (bit1 ^ bit2));

            // Insert the result bit at the beginning of the sum
            sum.insert(0, resultBit);
        }

        // If there's a final carry, include it in the result
        if (carry > 0) {
            sum.insert(0, carry);
        }

        return sum.toString();
    }
    // Function to pad a binary number with leading zeros to a specified length
    private static String padWithZeros(String binary, int length) {
        StringBuilder paddedBinary = new StringBuilder(binary);
        while (paddedBinary.length() < length) {
            paddedBinary.insert(0, '0');
        }
        String binary1 = "00101101";
        String binary2 = "11110100";
        return paddedBinary.toString();

    }
    public static void main(String[] args) {

        // Binary numbers to be added
        String binary1 = "1101";
        String binary2 = "1011";
        // Ensure both binary numbers have the same length by padding with leading zeros if necessary
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = padWithZeros(binary1, maxLength);
        binary2 = padWithZeros(binary2, maxLength);
        // Perform binary addition
        String sum = performBinaryAddition(binary1, binary2);
        // Print the results
        System.out.println("Binary 1:   " + binary1);
        System.out.println("Binary 2: + " + binary2);
        System.out.println("--------- carry ----------");
        System.out.println("---------   |   ----------");
        System.out.println("---------   v   ----------");
        // Print each step of the addition with carry
        int carry = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(binary1.charAt(i));
            int bit2 = Character.getNumericValue(binary2.charAt(i));
            int resultBit = Character.getNumericValue(sum.charAt(i));
            // Calculate the sum and carry
            int tempSum = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (carry & (bit1 ^ bit2));
            // Print the result bit and carry
            System.out.println("    " + bit1 + " + " + bit2 + " + " + carry + " = " + resultBit);
            // Insert the result bit at the beginning of the sum
            sum = tempSum + sum.substring(1);
        }
        // Print the final carry and the final sum
        System.out.println("--------------------------");
        System.out.println("   Sum:    " + carry + sum);
    }
}
