package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 23/01/23 11:43 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Power_calculation {
    /**
     * Given A, N. Find A^N using recursion.
     * A = 2;
     * N = 5;
     * 2 * 2 * 2 * 2 * 2
     * <p>
     * Assumption: Calculate & return A^N
     * <p>
     * **/
    // Approach 1
    private static int pow(int A, int N) {
        // Base case
        if (N == 0) {
            return 1;
        }
        return pow(A, N - 1) * A;
    }
    // Approach 1
    private static int pow1(int A, int N) {
        // Base case
        if (N == 0) {
            return 1;
        }
        if ((N & 1) == 0) {
            return pow1(A, N / 2) * pow1(A, N / 2);
        } else {
            return pow1(A, N / 2) * pow1(A, N / 2) * A;
        }
    }
    // Approach 2
    private static int pow2(int A, int N) {
        // Base case
        if (N == 0) {
            return 1;
        }
        int p = pow2(A, N / 2);
        if ((N & 1) == 0) {
            return p * p;
        } else {
            return p * p * A;
        }
    }
    // Recursive function to calculate power
    private static int power(int base, int exponent) {
        // Base case: any number raised to the power of 0 is 1
        if (exponent == 0) {
            return 1;
        }
        // Recursive call to calculate power
        return base * power(base, exponent - 1);
    }
    public static void main(String[] args) {
        int A = 2;
        int N = 5;

        int result = pow(A, N);
        System.out.println(A + " raised to the power of " + N + " is: " + result);

        result = pow1(A, N);
        System.out.println(A + " raised to the power of " + N + " is: " + result);

        result = pow2(A, N);
        System.out.println(A + " raised to the power of " + N + " is: " + result);

        int base = 2;
        int exponent = 5;
        result = power(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}
