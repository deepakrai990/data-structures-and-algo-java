package com.scaler.core.java_2_intermediate.dsa_24_recursion_2;

/**
 * @created 13/10/22 2:44 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Main {

    private static int solve(int n, long k) {
        if(n == 1) {
            return 0;
        }
        int parent = solve(n - 1, (long) (k + 1L) / 2L);
        if(k % 2L == 0L) {
            return parent == 1 ? 1 : 0;
        } else {
            return parent;
        }
    }
    private static int kthGrammar(int n, int k) {
        if(n == 1) {
            return 0;
        }
        int parent = kthGrammar(n-1, (k + 1) / 2);
        if(k % 2 == 0) {
            return parent == 1 ? 0 : 1;
        } else {
            return parent;
        }
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 1;
        int result = solve(A, (long) B);
        System.out.println("Result : " + result);

        result = kthGrammar(A, B);
        System.out.println("Result : " + result);
    }
}
