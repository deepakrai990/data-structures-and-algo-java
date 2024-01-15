package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q4_Subtraction_of_binary_numbers1 {
    private static String addBinary(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(binary1.length(), binary2.length());
        // Ensure both binary numbers have the same length by padding with leading zeros if necessary
        binary1 = padWithZeros(binary1, maxLength);
        binary2 = padWithZeros(binary2, maxLength);
        // Perform binary addition
        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(binary1.charAt(i));
            int bit2 = Character.getNumericValue(binary2.charAt(i));
            // Calculate the sum and carry
            int sum = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (carry & (bit1 ^ bit2));
            // Insert the result bit at the beginning of the result
            result.insert(0, sum);
        }
        return result.toString();
    }
    private static String padWithZeros(String binary, int length) {
        StringBuilder paddedBinary = new StringBuilder(binary);
        while (paddedBinary.length() < length) {
            paddedBinary.insert(0, '0');
        }
        return paddedBinary.toString();
    }
    public static void main(String[] args) {
        String binary1 = Integer.toBinaryString(45); //"00101101";
        String binary2 = Integer.toBinaryString(-12); // "11110100";
        System.out.println("Binary 1:     " + binary1);
        System.out.println("Binary 2: +   " + binary2);
        System.out.println("--------------");
        // Perform binary addition without the last carry
        String result = addBinary(binary1, binary2);
        // Print each step of the addition without the last carry
        for (int i = binary1.length() - 1; i >= 0; i--) {
            int bit1 = Character.getNumericValue(binary1.charAt(i));
            int bit2 = Character.getNumericValue(binary2.charAt(i));
            int resultBit = Character.getNumericValue(result.charAt(i));
            System.out.println("    " + bit1 + " + " + bit2 + " = " + resultBit);
        }
        // Print the final result without the last carry
        System.out.println("--------------");
        System.out.println("Result:       " + result);
    }
}
