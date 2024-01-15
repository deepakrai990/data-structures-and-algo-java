package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q3_Array_Mod {
    /**
     * Problem: Power Mod
     * Given a number in A[N] format. Calculate A[N] % mod.
     * Each A[i] represents a single digit.
     * **/
    // Bruteforce Approach
    // Function to calculate A[N] % mod for a large number represented by an array (Brute Force)
    public static int calculateModulo(int[] A, int mod) {
        // Convert the array of digits to a number
        int number = arrayToNumber(A);
        // Apply the modulo operation
        return number % mod;
    }
    // Function to convert an array of digits to a number
    public static int arrayToNumber(int[] A) {
        int number = 0;
        // Iterate through each digit in the array
        for (int i = 0; i < A.length; i++) {
            // Multiply the current number by 10 and add the current digit
            number = number * 10 + A[i];
        }
        return number;
    }
    // Optimise Approach 1
    private static long arrayMod(int[] A, int mod) {
        int N = A.length;
        long sum = 0L, t = 1L;
        for (int i = N - 1; i >= 0; i--) {
            sum = (sum + A[i] * t) % mod;
            t = (t * 10) % mod;
        }
        return sum;
    }
    // Optimise Approach 2 Function to calculate A[N] % mod for a large number represented by an array
    public static int calculateModulo1(int[] A, int mod) {
        int result = 0;
        // Iterate through each digit in the array
        for (int i = 0; i < A.length; i++) {
            // Multiply the current result by 10 and add the current digit
            result = (result * 10 + A[i]) % mod;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {6, 2, 3, 4, 3};
        int mod = 49;
        // Calculate (62343) % 49 using brute force
        int result = calculateModulo(A, mod);
        // Print the result
        System.out.println("------------------Bruteforce Approach------------------");
        System.out.println("(" + arrayToNumber(A) + ") % " + mod + " = " + result);

        System.out.println("-------------------Optimise Approach 1------------------");
        long result1 = arrayMod(A, mod);
        System.out.println("(" + arrayToNumber(A) + ") % " + mod + " = " + result1);

        System.out.println("-------------------Optimise Approach 2------------------");
        result = calculateModulo1(A, mod);
        System.out.println("(" + arrayToNumber(A) + ") % " + mod + " = " + result);

    }
}
