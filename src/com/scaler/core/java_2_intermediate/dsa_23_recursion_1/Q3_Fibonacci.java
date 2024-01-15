package com.scaler.core.java_2_intermediate.dsa_23_recursion_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q3_Fibonacci {
    /**
     * Problem: Given N, calculate and return N th fibonacci number
     * **/
    private static int fibonacci(int N) {
        // Base case
        if (N <= 1) {
            return N;
        }
        return fibonacci(N - 1) + fibonacci(N - 2);
    }
    // Recursive function to calculate the nth Fibonacci number
    private static int fibonacci1(int n) {
        // Base case: Fibonacci of 0 is 0, and Fibonacci of 1 is 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // Recursive calls to calculate the Fibonacci of (n-1) and (n-2)
        int fibNMinus1 = fibonacci1(n - 1);
        int fibNMinus2 = fibonacci1(n - 2);
        // Calculate the nth Fibonacci number
        return fibNMinus1 + fibNMinus2;
    }
    public static void main(String[] args) {
        int N = 7;

        int result = fibonacci(N);
        System.out.println("Fibonacci Series up to " + N + " : " + result);

        System.out.println("------------------------");

        System.out.print("Fibonacci Series up to " + N + " : ");
        for (int i = 0; i <= N; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\n------------------------");
        System.out.print("Fibonacci Series up to " + N + " : ");
        for (int i = 0; i <= N; i++) {
            System.out.print(fibonacci1(i) + " ");
        }
    }
}
