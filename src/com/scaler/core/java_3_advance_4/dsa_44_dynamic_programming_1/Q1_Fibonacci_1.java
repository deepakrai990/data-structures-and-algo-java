package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Fibonacci_1 {
    /**
     * T.C: O(N^2)
     * S.C: O(N)
     * **/
    private static int fibonacci(int N) {
        if (N <= 1) {
            return N;
        }
        return fibonacci(N - 1) + fibonacci(N - 2);
    }

    public static void main(String[] args) {
        int N1 = 8;
        int result = fibonacci(N1);
        PrintUtils.print(result);
    }
}
