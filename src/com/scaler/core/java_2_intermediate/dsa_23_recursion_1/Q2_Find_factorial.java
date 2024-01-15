package com.scaler.core.java_2_intermediate.dsa_23_recursion_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q2_Find_factorial {
    /**
     * Problem: Given N, find and return N!
     * **/
    private static int fact(int N) {
        // Base case
        if (N == 1) {
            return 1;
        }
        return N * fact(N - 1);
    }
    // Recursive function to calculate the factorial of N
    private static long factorial(int N) {
        // Base case: factorial of 0 is 1
        if (N == 0) {
            return 1;
        }
        // Recursive call to calculate the factorial of (N-1)
        long factorialOfPrevious = factorial(N - 1);
        // Calculate the factorial of N
        // Return the result
        return N * factorialOfPrevious;
    }
    public static void main(String[] args) {
        int N = 4;

        int result = fact(N);
        System.out.println(N + "! = " + result);

        result = (int) factorial(N);
        System.out.println(N + "! = " + result);
    }
}
