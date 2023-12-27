package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 23/01/23 11:43 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Given A, N. Find A^N using recursion.
     * A = 2;
     * N = 5;
     * 2 X 2 X 2 X 2 X 2
     *
     * Assumption: Calculate & return A^N
     *
     * **/
    private static int pow(int A, int N) {
        if (N == 0) {
            return 1;
        }
        return pow(A, N - 1) * A;
    }
    public static void main(String[] args) {
        int A = 2;
        int N = 5;
        int result = pow(A, N);
        System.out.println("Result : " + result);
    }
}
