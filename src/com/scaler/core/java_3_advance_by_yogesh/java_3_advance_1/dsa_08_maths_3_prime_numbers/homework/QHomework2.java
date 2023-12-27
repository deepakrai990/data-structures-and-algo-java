package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Arrays;

/**
 * @created 11/02/23 7:16 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int[] primeSum(int A) {
        int[] outPut = new int[2];
        boolean[] isPrime = new boolean[A + 1];
        isPrime = sieve(isPrime, A);

        for (int i = 2; i < isPrime.length; i++) {
            int a = A - i;
            int b = i;
            if (isPrime[a] && isPrime[b]) {
                outPut[0] = a;
                outPut[1] = b;
            }
        }
        return outPut;
    }

    private static boolean[] sieve(boolean[] isPrime, int A) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int A = 4;
        int[] results = primeSum(A);
        PrintUtils.print1DArray(results);
    }
}
