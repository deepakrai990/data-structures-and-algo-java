package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q3_Minimum_numbers_of_perfect_squares_2 {
    // Function to calculate the minimum number of perfect squares required to reach sum N
    private static int minPerfectSquares(int N) {
        // Create a table to store the minimum number of perfect squares for each sum up to N
        int[] dp = new int[N + 1];
        // Base case: The minimum number of perfect squares for sum 0 is 0
        dp[0] = 0;
        // Calculate the minimum number of perfect squares for each sum up to N
        for (int i = 1; i <= N; i++) {
            // Initialize the minimum to a large value
            dp[i] = Integer.MAX_VALUE;
            // Try all possible perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update the minimum based on the previously calculated values
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // The result is stored in the last entry of the dp array (sum N)
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 12; // Replace with the desired sum
        int minSquares = minPerfectSquares(N);
        System.out.println("Minimum number of perfect squares to reach sum " + N + ": " + minSquares);
    }
}
