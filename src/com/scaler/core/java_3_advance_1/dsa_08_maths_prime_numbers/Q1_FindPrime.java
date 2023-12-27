package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 8:36 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_FindPrime {
    private static boolean isPrime(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c == 2) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 9;
        boolean result = isPrime(n);
        PrintUtils.print(result);
    }
}
