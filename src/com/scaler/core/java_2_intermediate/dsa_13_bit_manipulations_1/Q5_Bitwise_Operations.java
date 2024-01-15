package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q5_Bitwise_Operations {
    public static void main(String[] args) {
        int num1 = 0b11001100; // 204 // Binary literal in Java (0b prefix)
        int num2 = 0b00110011; // 51
        System.out.println(num1 + " " + num2);
        // AND (&) Example
        int resultAND = num1 & num2;
        System.out.println(num1 + " & " + num2 + " : " + Integer.toBinaryString(resultAND));
        // System.out.println("AND Result: " + Integer.toBinaryString(resultAND));

        // OR (|) Example
        int resultOR = num1 | num2;
        System.out.println(num1 + " | " + num2 + " : " + Integer.toBinaryString(resultOR));
        // System.out.println("OR Result: " + Integer.toBinaryString(resultOR));

        // XOR (^) Example
        int resultXOR = num1 ^ num2;
        System.out.println(num1 + " ^ " + num2 + " : " + Integer.toBinaryString(resultXOR));
        // System.out.println("XOR Result: " + Integer.toBinaryString(resultXOR));

        // NOT (~) Example
        int resultNOT1 = ~num1;
        System.out.println("~" +num1 + " : " + Integer.toBinaryString(resultNOT1));
        // System.out.println("NOT Result 1: " + Integer.toBinaryString(resultNOT1));

        int resultNOT2 = ~num2;
        System.out.println("~" +num2 + " :" + Integer.toBinaryString(resultNOT2));
        // System.out.println("NOT Result 2: " + Integer.toBinaryString(resultNOT2));

        // Left Shift (<<) Example
        int resultLeftShift = num1 << 2;
        System.out.println(num1 + " << " + 2 + " : " + Integer.toBinaryString(resultLeftShift));
        // System.out.println("Left Shift Result: " + Integer.toBinaryString(resultLeftShift));

        // Right Shift (>>) Example
        int resultRightShift = num1 >> 2;
        System.out.println(num1 + " >> " + 2 + " : " + Integer.toBinaryString(resultRightShift));
        // System.out.println("Right Shift Result: " + Integer.toBinaryString(resultRightShift));

        // Unsigned Right Shift (>>>) Example
        int resultUnsignedRightShift = num1 >>> 2;
        System.out.println(num1 + ">>>" + 2 + " : " + Integer.toBinaryString(resultUnsignedRightShift));
        System.out.println("Unsigned Right Shift Result: " + Integer.toBinaryString(resultUnsignedRightShift));
    }
}
