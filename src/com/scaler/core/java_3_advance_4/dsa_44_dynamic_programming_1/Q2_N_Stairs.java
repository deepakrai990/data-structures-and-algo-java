package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q2_N_Stairs {
    /**
     * Problem: N Stairs
     * Given N steps. In how many ways can we go from 0th step to Nth step?
     * Note: From an ith step, we can go to (i + 1)th or (i + 2)th step.
     * **/
    // Function to calculate the number of ways to reach the Nth step
    private static int countWaysToNthStep(int N) {
        if (N <= 1) {
            return 1; // There is only one way to reach the 0th and 1st steps
        }
        // Create a table to store the number of ways for each step
        int[] DP = new int[N + 1];
        // Base cases: There is one way to reach the 0th and 1st steps
        DP[0] = 1;
        DP[1] = 1;
        // Calculate the number of ways for each step starting from the 2nd step
        for (int i = 2; i <= N; i++) {
            // The number of ways to reach the ith step is the sum of ways to reach (i-1)th and (i-2)th steps
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        // The result is stored in the last entry of the ways array (Nth step)
        return DP[N];
    }
    public static void main(String[] args) {
        int N = 5;
        int result = countWaysToNthStep(N);
        PrintUtils.print(result);
    }
}
