package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class Q2_Calculate_Power_Mod2 {
    // Function to calculate (a^n) % mod using modular exponentiation
    public static long calculateModularExponentiation(long a, long n, long mod) {
        if (mod == 1) {
            return 0;  // Special case: mod is 1, and any number % 1 is 0
        }
        long result = 1;
        a = a % mod;  // Take modulo of a with mod
        while (n > 0) {
            // If the current power is odd, multiply result with a
            if((n & 1) == 1) { // Checking n is odd with bitwise operation // if (n % 2 == 1) {
                result = (result * a) % mod;
            }
            // Reduce the power by half and square a
            a = (a * a) % mod;
            n = n / 2;
        }
        return result;
    }
    public static void main(String[] args) {
        long a = 5;
        long n = 2;
        long mod = 1000000007;  // Example mod value
        // Calculate (a^n) % mod
        long result = calculateModularExponentiation(a, n, mod);
        // Print the result
        System.out.println("(" + a + "^" + n + ") % " + mod + " = " + result);
    }
}
