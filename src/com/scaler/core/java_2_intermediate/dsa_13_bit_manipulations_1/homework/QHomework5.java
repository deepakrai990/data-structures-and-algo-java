package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @created 21/09/22 4:43 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QHomework5 {
    /**
     * Q5. Bit Operations - 3
     *
     * What happens to the 0-th bit in a when we perform a = a^1 ?
     *
     * Scaler Solution
     * The operation a^1 toggles the 0-th bit of a.
     * **/
    public static void main(String[] args) {
        int a = 10;
        System.out.println("a : " + Integer.toBinaryString(a));
        a = a^1;
        System.out.println("Result : " + Integer.toBinaryString(a));
    }
}
