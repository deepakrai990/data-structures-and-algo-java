package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 23/01/23 12:13 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Power_mod_calculation {
    /**
     * Given A, N, M. Calculate (A ^ N) % M.
     * Constraints
     * 1 <= A <= 10^7
     * 1 <= N <= 10^9
     * 1 <= M <= 10^9
     * **/
    private static int powmode(int A, int N, int M) {
        if (N == 0) {
            return 1;
        }
        long P = powmode(A, N / 2, M);
        if (N % 2 == 0) {
            return (int) (P * P) %  M;
        } else {
            return  (int) ( ( (P * P) % M) * A ) % M;
        }
    }
    // Recursive function to calculate (A^N) % M
    private static int moduloPower(int A, int N, int M) {
        // Base case: any number raised to the power of 0 is 1
        if (N == 0) {
            return 1 % M;
        }
        // Recursive call to calculate power
        return ((A % M) * (moduloPower(A, N - 1, M) % M)) % M;
    }
    public static void main(String[] args) {
        int A = 2;
        int N = 11;
        int M = 7;
        int result = powmode(A, N, M);
        System.out.println("(" + A + "^" + N + ") % " + M + " is: " + result);

        result = moduloPower(A, N, M);
        System.out.println("(" + A + "^" + N + ") % " + M + " is: " + result);
    }
}
