package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 23/01/23 12:13 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion4 {
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
    public static void main(String[] args) {
        int A = 2;
        int N = 11;
        int M = 7;
        int result = powmode(A, N, M);
        System.out.println("Result : " + result);
    }
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || G <= A || D <= F || H <= B) {
            return 0;
        } else{
            int width = Math.min(C,G)-Math.max(A,E);
            int height = Math.min(H,D)-Math.max(B,F);

            return width*height;
        }
    }
}
