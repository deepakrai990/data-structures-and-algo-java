package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 17/12/23
 * @project scaler_course_code
 */
public class Q1_Fibonacci_4 {
    /**
     * Iterative DP with space Optimization
     * T.C: O(N) * 1 = O(N)
     * S.C: O(1)
     * **/
    private static int fibonacci(int N) {
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= N; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        int N = 8;
        int result = fibonacci(N);
        PrintUtils.print(result);
    }
}
