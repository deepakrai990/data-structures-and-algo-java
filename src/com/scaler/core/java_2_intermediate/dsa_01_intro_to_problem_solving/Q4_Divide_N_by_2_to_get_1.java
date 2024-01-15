package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class Q4_Divide_N_by_2_to_get_1 {
    private static int countDivisions(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer");
        }
        int count = 0;
        // Keep diving N by 2 until it becomes 1
        while (N > 1) {
            N = N / 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 32; // Replace this with the value of N you want to test

        int result = countDivisions(N);
        PrintUtils.print("Number of divisions needed for " + N + ": " + result);
    }
}
