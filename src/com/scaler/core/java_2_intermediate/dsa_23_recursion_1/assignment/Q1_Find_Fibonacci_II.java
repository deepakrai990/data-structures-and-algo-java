package com.scaler.core.java_2_intermediate.dsa_23_recursion_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/10/22 12:20 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q1_Find_Fibonacci_II {
    private static int findAthFibonacci(int A) {
        if ( A<= 1)
            return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }

    public static void main(String[] args) {
        int A = 9;
        int result = findAthFibonacci(A);
        PrintUtils.printInt(result);
    }
}
