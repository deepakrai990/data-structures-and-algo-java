package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q3_Minimum_numbers_of_perfect_squares_3 {
    // Function to calculate the minimum number of perfect squares required to reach sum N
    private static int minPerfectSquares(int N) {
        // Base case: If N is 0, no perfect squares are needed
        if (N == 0) {
            return 0;
        }
        // Initialize the count of perfect squares
        int count = 0;
        // Iterate until the sum becomes zero
        while (N > 0) {
            // Find the largest perfect square less than or equal to N
            int largestSquare = findLargestSquare(N);
            // Subtract the largest perfect square from the sum
            N -= largestSquare;
            // Increment the count
            count++;
        }
        return count;
    }

    // Function to find the largest perfect square less than or equal to a given number
    private static int findLargestSquare(int num) {
        int candidate = 1;
        int square = 1;
        while (square <= num) {
            candidate = square;
            square = (candidate + 1) * (candidate + 1);
        }
        return candidate;
    }
    public static void main(String[] args) {
        int N = 12; // Replace with the desired sum
        int minSquares = minPerfectSquares(N);
        System.out.println("Minimum number of perfect squares to reach sum " + N + ": " + minSquares);
    }
}
