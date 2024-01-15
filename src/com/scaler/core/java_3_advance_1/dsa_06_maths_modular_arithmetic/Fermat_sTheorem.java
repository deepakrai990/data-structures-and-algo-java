package com.scaler.core.java_3_advance_1.dsa_06_maths_modular_arithmetic;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Fermat_sTheorem {
    // Function to find the modular inverse using Fermat's Little Theorem
    private static long modInverseFermat(long a, long p) {
        // Check if p is prime
        if (!isPrime(p)) {
            throw new IllegalArgumentException("Modulus must be a prime number.");
        }
        // Calculate and return a^(p-2) mod p
        return power(a, p - 2, p);
    }
    // Function to calculate the modular exponentiation (a^b mod m)
    private static long power(long a, long b, long m) {
        long result = 1;
        a = a % m; // Take modulo of a with m
        while (b > 0) {
            // If b is odd, multiply result with a
            if (b % 2 == 1) {
                result = (result * a) % m;
            }
            // b must be even now, divide it by 2
            b = b / 2;
            a = (a * a) % m;
        }
        return result;
    }
    // Function to check if a number is prime
    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Given values
        long a = 3;
        long p = 11;
        // Calculate the modular inverse using Fermat's Little Theorem
        long inverse = modInverseFermat(a, p);
        // Display the result
        System.out.println("Modular Inverse of " + a + " modulo " + p + " using Fermat's Little Theorem is: " + inverse);
    }
}
