package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q3_Addition_of_binary_numbers1 {
    public static String addBinary(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(binary1.length(), binary2.length());
        for (int i = 0; i < maxLength; i++) {
            // Get the individual bits from each binary number (pad with 0 if necessary) from the last index
            int bit1 = i < binary1.length() ? Character.getNumericValue(binary1.charAt(binary1.length() - 1 - i)) : 0;
            int bit2 = i < binary2.length() ? Character.getNumericValue(binary2.charAt(binary2.length() - 1 - i)) : 0;
            // Calculate the sum and carry
            int sum = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (carry & (bit1 ^ bit2));
            // Add the sum to the beginning of the result
            result.insert(0, sum);
        }
        // If there's a final carry, include it in the result
        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String binary1 = "10110"; // "1101";
        String binary2 = "00111"; // "1011";
        String sum = addBinary(binary1, binary2);

        System.out.println("Binary 1: " + binary1);
        System.out.println("Binary 2: " + binary2);
        System.out.println("Sum: " + sum);
    }
}
