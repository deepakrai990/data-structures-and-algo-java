package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class ModularInverse {
    // Function to find the GCD of two numbers using the Extended Euclidean Algorithm
    // Returns an array {gcd, x, y} where gcd is the GCD, and x, y are coefficients
    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] vals = extendedGCD(b, a % b);
            int gcd = vals[0];
            int x = vals[2];
            int y = vals[1] - (a / b) * vals[2];
            return new int[]{gcd, x, y};
        }
    }

    // Function to find the modular inverse of a modulo m
    // Returns -1 if the modular inverse does not exist
    private static int modInverse(int a, int m) {
        int[] values = extendedGCD(a, m);
        int gcd = values[0];
        int x = values[1];
        // int y = values[2];
        if (gcd != 1) {
            // Modular inverse does not exist
            return -1;
        } else {
            // Ensure the result is non-negative
            return (x % m + m) % m;
        }
    }

    public static void main(String[] args) {
        // Given values
        int a = 3;
        int m = 11;
        // Calculate the modular inverse
        int inverse = modInverse(a, m);
        // Display the result
        if (inverse != -1) {
            System.out.println("Modular Inverse of " + a + " modulo " + m + " is: " + inverse);
        } else {
            System.out.println("Modular Inverse does not exist for " + a + " modulo " + m);
        }
    }
}
