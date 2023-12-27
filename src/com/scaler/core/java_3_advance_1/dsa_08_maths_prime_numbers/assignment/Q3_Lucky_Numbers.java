package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:46 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Lucky_Numbers {
    private static int solve(int A) {
        int[] primes = new int[A + 1];
        for (int i = 2; i < A; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= A; j += i) {
                    primes[j] += 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= A; i++) {
            if (primes[i] == 2) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int  A = 12;
        int result = solve(A);
        PrintUtils.printInt(result);
    }
}
