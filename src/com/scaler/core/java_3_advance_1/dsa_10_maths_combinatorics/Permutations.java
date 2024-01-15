package com.scaler.core.java_3_advance_1.dsa_10_maths_combinatorics;

/**
 * @author Deepak Kumar Rai
 * @created 14/01/24
 * @project scaler_course_code
 */
public class Permutations {
    // Function to calculate the factorial of a number
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Function to calculate P(n, r) - permutations of n items taken r at a time
    private static int permutations(int n, int r) {
        if (n < r) {
            return 0; // Invalid input, r should be less than or equal to n
        }
        return factorial(n) / factorial(n - r);
    }

    public static void main(String[] args) {
        int n = 5; // Total number of items
        int r = 3; // Number of items to arrange

        int result = permutations(n, r);
        System.out.println("Number of ways to arrange " + r + " items out of " + n + ": " + result);
    }
}
