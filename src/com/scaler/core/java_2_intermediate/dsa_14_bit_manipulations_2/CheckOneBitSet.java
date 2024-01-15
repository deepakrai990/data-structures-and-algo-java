package com.scaler.core.java_2_intermediate.dsa_14_bit_manipulations_2;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class CheckOneBitSet {
    private static boolean hasOnlyOneBitSet(int num) {
        int count = 0;
        // Loop through each bit of the binary number
        while (num > 0) {
            // Check the least significant bit
            if ((num & 1) == 1) {
                count++;
            }
            // Right shift to check the next bit
            num = num >> 1;
        }
        // Check if only one bit is set
        return count == 1;
    }
    public static void main(String[] args) {
        int binaryNumber = 0b00010000; // Example: binary number with only one-bit set at position 5
        System.out.println("binaryNumber : " + binaryNumber);
        // Check if the binary number has only a one-bit set
        boolean result = hasOnlyOneBitSet(binaryNumber);
        // Print the result
        if (result) {
            System.out.println("The binary number has only one bit set.");
        } else {
            System.out.println("The binary number does not have only one bit set.");
        }
    }
}
