package com.scaler.core.java_2_intermediate.dsa_24_recursion_2.homework;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 13/10/22 9:02 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Kth_Symbol_Easy {
    private static int solve(int A, int B) {
        if (A == 1) return 0;
        int previousIndex = B / 2;
        int digit = solve(A - 1, previousIndex);
        if (digit == 0){
            return B % 2 == 0 ? 0 : 1;
        } else {
            return B % 2 == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 4;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
