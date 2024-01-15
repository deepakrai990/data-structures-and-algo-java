package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class Q3_Find_Sum_of_all_Numbers_1_to_100 {
    private static int calculateArithmeticSeries(int N) {
        return (N * (N + 1)) / 2;
    }

    public static void main(String[] args) {
        int N = 100;

        int result = calculateArithmeticSeries(N);
        PrintUtils.print("The sum of all numbers from 1 to " + N + " is: " + result);
    }
}
