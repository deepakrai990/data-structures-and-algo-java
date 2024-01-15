package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class ModularDivision {
    // Function to calculate the modular inverse using the Extended Euclidean Algorithm
    private static int calculateModularInverse(int a, int m) {
        int[] extendedEuclideanResult = extendedEuclidean(a, m);
        int gcd = extendedEuclideanResult[0];
        int x = extendedEuclideanResult[1];
        // Check if a and m are coprime
        if (gcd != 1) {
            throw new ArithmeticException("Modular inverse does not exist. Numbers are not coprime.");
        }
        // Ensure x is positive and within the range [0, m-1]
        x = (x % m + m) % m;
        return x;
    }
    // Extended Euclidean Algorithm
    private static int[] extendedEuclidean(int a, int m) {
        int x1 = 1, y1 = 0;
        int x2 = 0, y2 = 1;
        while (m != 0) {
            int q = a / m;
            int r = a % m;

            int x = x1 - q * x2;
            int y = y1 - q * y2;

            // Update values for the next iteration
            a = m;
            m = r;
            x1 = x2;
            y1 = y2;
            x2 = x;
            y2 = y;
        }
        // Return [gcd, x1, y1]
        return new int[]{a, x1, y1};
    }
    // Function to perform modular division using modular inverse
    public static int modDiv(int numerator, int denominator, int modulus) {
        // Calculate the modular inverse of the denominator
        int inverse = calculateModularInverse(denominator, modulus);
        // Multiply the inverse with the numerator and take modulo
        return (numerator * inverse) % modulus;
    }
    public static void main(String[] args) {
        int numerator = 15;
        int denominator = 3;
        int modulus = 7;
        try {
            // Perform modular division
            int result = modDiv(numerator, denominator, modulus);
            // Print the result
            System.out.println("Modular Division: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
