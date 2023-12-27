package com.scaler.contest.daily_coding_problem;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 11/10/23
 * @project scaler_course_code
 */
public class Problem_317 {
    /**
     * Write a function that returns the bitwise AND of all integers between M and N, inclusive.
     * **/
    private static int rangeBitwiseAnd(int M, int N) {
        int shift = 0;
        // Right-shift both M and N until they are equal
        while (M < N) {
            M >>= 1; // Right-shift M
            N >>= 1; // Right-shift N
            shift++;
        }
        // Left-shift one of them back by the same amount to find the common prefix
        return M << shift;
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 15;
        int result = rangeBitwiseAnd(M, N);
        PrintUtils.print(result);
    }
}
