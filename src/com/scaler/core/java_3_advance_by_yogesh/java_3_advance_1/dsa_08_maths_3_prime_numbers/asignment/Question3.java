package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers.asignment;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 19/01/23 10:49 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Question3 {
    private static int[] solve(int A) {
        boolean[] primes = new boolean[A + 1];
        Arrays.fill(primes, Boolean.TRUE);
        primes[0] = Boolean.FALSE;
        primes[1] = Boolean.FALSE;

        for (int i = 2; i * i <= A; i++) {
            if (primes[i] == Boolean.TRUE) {
                for (int j = i * i; j <= A; j += i) {
                    primes[j] = Boolean.FALSE;
                }
            }
        }

        int trueCount = 0;
        for (int i = 2; i <= A; i++) {
            if (primes[i] == Boolean.TRUE) {
                trueCount++;
            }
        }
        int[] result = new int[trueCount];
        int index = 0;
        for (int i = 2; i <= A; i++) {
            if (primes[i] == Boolean.TRUE) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A = 12;
        int[] results = solve(A);
        PrintUtils.print1DArray(results);
    }
}
