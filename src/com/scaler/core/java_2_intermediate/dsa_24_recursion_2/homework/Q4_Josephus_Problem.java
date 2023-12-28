package com.scaler.core.java_2_intermediate.dsa_24_recursion_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 13/10/22 9:03 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Josephus_Problem {
    private static int solve(int A, int B) {
        if (A == 1)
            return 1;
        else
            return (solve(A - 1, B) + B - 1) % A + 1;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 3;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
