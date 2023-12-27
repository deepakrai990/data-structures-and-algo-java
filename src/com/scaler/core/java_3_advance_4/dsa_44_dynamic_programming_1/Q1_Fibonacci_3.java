package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Fibonacci_3 {
    /**
     * Tabulation: Iterative + Memory [Bottom Up]
     * **/
    private static int fibonacci(int N) {
        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[N];
    }
    /**
     * T.C: O(N) * 1 = O(N)
     * S.C: O(N)
     * **/
    private static int[] fibonacci_1(int N) {
        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP;
    }
    public static void main(String[] args) {
        int N = 8;
        int result = fibonacci(N);
        PrintUtils.print(result);
        int[] results = fibonacci_1(N);
        PrintUtils.print(results);
    }
}
