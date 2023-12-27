package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/09/23 11:06 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_FindPrime_Optimise {
    private static boolean isPrime(int n) {
        int c = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n % i == i) {
                    c++;
                } else {
                    c += 2;
                }
            }
        }
        if (c == 2) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 53;
        boolean result = isPrime(n);
        PrintUtils.print(result);
    }
}
