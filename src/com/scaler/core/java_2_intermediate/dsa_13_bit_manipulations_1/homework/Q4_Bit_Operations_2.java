package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1.homework;

/**
 * @created 21/09/22 4:36 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q4_Bit_Operations_2 {
    /**
     * Q4. Bit Operations - 2
     * Given a=10, what will be the 0-th bit in a|1 ?
     *
     * Scaler Solutiom
     * Complete Solution
     * The operation a|1 sets the 0-th bit of a.
     * **/
    public static void main(String[] args) {
        int a = 10;
        a = a^1;

        System.out.println("Result : " + Integer.toBinaryString(a));
    }
}
