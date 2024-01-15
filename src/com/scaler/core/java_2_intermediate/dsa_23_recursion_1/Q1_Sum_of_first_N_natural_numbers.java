package com.scaler.core.java_2_intermediate.dsa_23_recursion_1;

/**
 * @author Deepak Kumar Rai
 * @created 08/01/24
 * @project scaler_course_code
 */
public class Q1_Sum_of_first_N_natural_numbers {
    /**
     * Problem: Given N, calculate and return the sum of first N natural numbers
     * **/
    private static int sum(int N) {
        // Base case
        if (N == 1) {
            return 1;
        }
        return sum(N - 1) + N;
    }
    // Recursive function to calculate the sum of first N natural numbers
    private static int sumOfNaturalNumbers(int N) {
        // Base case: a sum of first 0 natural numbers is 0
        if (N == 0) {
            return 0;
        }
        // Recursive call to calculate the sum of first (N-1) natural numbers
        return sumOfNaturalNumbers(N - 1) + N;
    }
    public static void main(String[] args) {
        int N = 10;

        int result = sumOfNaturalNumbers(N);
        System.out.println("Sum of first " + N + " natural numbers: " + result);

        result = sum(N);
        System.out.println("Sum of first " + N + " natural numbers: " + result);
    }
}
