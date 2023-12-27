package com.scaler.core.java_3_advance_4.dsa_46_dynamic_programming_3.homework;

/**
 * @created 02/04/23 10:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Ways_to_send_the_signal {
    int mod = 1000000007;
    int[][] dpArr;

    private int solve(int A) {
        dpArr = new int[A + 1][2];
        return (recursion(A, 0, 1) % mod + recursion(A, 1, 1) % mod) % mod;
    }

    private int recursion(int A, int last, int size) {
        if (size == A) {
            return 1;
        }

        if (dpArr[size][last] != 0) {
            return dpArr[size][last];
        }

        if (last == 1) {
            dpArr[size][last] = recursion(A, 0, size + 1) % mod;
            return dpArr[size][last];
        } else {
            dpArr[size][last] =
                    (recursion(A, 0, size + 1) % mod + recursion(A, 1, size + 1) % mod) % mod;
            return dpArr[size][last];
        }
    }
}
