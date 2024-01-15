package com.scaler.core.java_2_intermediate.dsa_17_maths_modular_arthimetic_introduction;

/**
 * @author Deepak Kumar Rai
 * @created 06/01/24
 * @project scaler_course_code
 */
public class ModularArithmeticExample {
    /**
     * Basic Operations in Modular Arithmetic:
     * 1. Addition:
     * (a + b) % m = ((a % m) + (b % m)) % m
     * 2. Subtraction:
     * (a − b) % m = ((a % m) − (b % m) + m) % m
     * 3. Multiplication:
     * (a * b) % m = ((a % m) * (b % m)) % m
     * 4. Exponentiation:
     * (a ^ b) % m = ((a % m) ^ b) % m
     * 5. Modular Inverse:
     *
     * **/

    // Function to perform modular addition
    public static int modAdd(int a, int b, int m) {
        return ((a % m) + (b % m)) % m;
    }

    // Function to perform modular subtraction
    public static int modSub(int a, int b, int m) {
        return ((a % m) - (b % m) + m) % m;
    }

    // Function to perform modular multiplication
    public static int modMul(int a, int b, int m) {
        return ((a % m) * (b % m)) % m;
    }

    // Function to perform modular exponentiation
    public static int modExp(int a, int b, int m) {
        if (b == 0) {
            return 1;
        } else {
            int result = modExp(a, b / 2, m);
            result = modMul(result, result, m);
            if (b % 2 == 1) {
                result = modMul(result, a, m);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int a = 17;
        int b = 23;
        int modulus = 7;

        // Perform modular arithmetic operations
        int additionResult = modAdd(a, b, modulus);
        int subtractionResult = modSub(a, b, modulus);
        int multiplicationResult = modMul(a, b, modulus);
        int exponentiationResult = modExp(a, b, modulus);

        // Print the results
        System.out.println("Modular Addition: " + additionResult);
        System.out.println("Modular Subtraction: " + subtractionResult);
        System.out.println("Modular Multiplication: " + multiplicationResult);
        System.out.println("Modular Exponentiation: " + exponentiationResult);
    }
}
