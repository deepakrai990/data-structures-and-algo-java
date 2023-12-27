package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 23/01/23 11:50 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Given A, N. Find A^N using recursion.
     * If N = 10;
     * A^5 * A^5
     * if N = 11;
     * A^5 * A^5 * A
     * **/
    private static int pow(int A, int N) {
        if (N == 0) {
            return 1;
        }
        if (N % 2 == 0) {
            return pow(A, N / 2) * pow(A, N / 2);
        } else {
            return pow(A, N / 2) * pow(A, N / 2) * A;
        }
    }
    public static void main(String[] args) {
        int A = 2;
        int N = 11;
        int result = pow(A, N);
        System.out.println("Result : " + result);
    }
}
