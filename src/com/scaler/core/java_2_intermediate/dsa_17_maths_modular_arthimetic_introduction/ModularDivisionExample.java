package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class ModularDivisionExample {
    // Function to calculate the modular inverse using the Extended Euclidean Algorithm
    private static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1) {
            return 0;
        }
        while (a > 1) {
            int q = a / m;
            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }
        if (x < 0) {
            x += m0;
        }
        return x;
    }
    // Function to perform modular division
    public static int modDiv(int a, int b, int m) {
        a = a % m;
        int inverse = modInverse(b, m);
        if (inverse == -1) {
            throw new ArithmeticException("Modular inverse does not exist.");
        }
        return (a * inverse) % m;
    }

    public static void main(String[] args) {
        int numerator = 5;
        int denominator = 2;
        int modulus = 7;

        // Perform modular division
        int result = modDiv(numerator, denominator, modulus);

        // Print the result
        System.out.println("Modular Division: " + result);
    }
}

