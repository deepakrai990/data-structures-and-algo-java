package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_2.dsa_18_searching_3_binary_search_on_answer;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 11/02/23 5:03 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Question 1. Given P Q & R. Find the count of magical number from 1 to R?
     * Example
     * p = 9, q = 12, r = 100
     * **/
    private static int countOfMagicalNumbers(int B, int C, int mid) {
        int countB = mid / B;
        int countC = mid / C;
        int commonFactors = mid / lcm(B, C);
        return (countB + countC - commonFactors);
    }
    /**
     * Using Brute Force
     * **/
    private static int countMagicalNumbersBT(int P, int Q, int R) {
        int count = 0;
        for (int i = 1; i <= R; i++) {
            if (i % P == 0 || i % Q == 0) count++;
        }
        return count;
    }
    private static int lcm(int A, int B) {
        return (A * B) / gcd(A, B);
    }
    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        int p = 9, q = 12, r = 100;
        int result = countOfMagicalNumbers(p, q, r);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        int result1 = countMagicalNumbersBT(p, q, r);
        PrintUtils.printInt(result1);
    }
}
