package com.scaler.core.java_3_advance_4.dsa_44_dynamic_programming_1.assignment;

/**
 * @created 02/04/23 10:23 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Stairs {
    private static int climbStairs(int A) {
        int a = 1, b = 1, res = 1;
        for (int i = 1; i < A; i++) {
            res = (a + b) % 1000000007;
            a = b;
            b = res;
        }
        return res;
    }
}
