package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Fibonacci_2 {
    /**
     * Dynamic Programming: A given problem can be solved via subproblems.
     *      => Recursion (Optimal substructure).
     * Some problems used again and again => Overlapping subproblems
     * Every unique subproblem, solve it once, store it and re-use it again & again
     * Memoization: DP with Recursion + Memory [Top - Down]
     * **/
    private static int[] DP;
    private static int fibonacci(int N) {
        if (N <= 1) {
            return N;
        }
        if (DP[N] == - 1) { // Calculate for the first time
            // Calculate fibonacci(N)
            DP[N] = fibonacci(N - 1) + fibonacci(N - 2);
        }
        return DP[N];
    }
    /**
     * T.C: # DP subproblems * T.C for each problem
     * T.C: N * 1 = O(N)
     * S.C: O(N + N) [array + stack size]
     * **/
    public static void main(String[] args) {
        int N = 8;
        DP = new int[N + 1];
        Arrays.fill(DP, -1);
        int result = fibonacci(N);
        PrintUtils.print(result);
    }
}
