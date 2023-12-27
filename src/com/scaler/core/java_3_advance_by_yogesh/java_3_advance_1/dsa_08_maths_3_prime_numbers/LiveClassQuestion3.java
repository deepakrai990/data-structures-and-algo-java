package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 22/02/23 11:45 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion3 {
    /**
     * Given N, Return the smallest prime factor for all numbers from 2 to N.
     **/
    private static int[] findSmallestPrimeFactors(int n) {
        // spf (The Smallest Prime Factors)
        int[] spf = new int[n + 1];
        // For all spf[i] = i
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) { // spf[i] is prime
                for (int j = i * i; j <= n; j = j + i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    public static int[] leastPrimeFactor(int n) {
        // Create a vector to store least primes.
        // Initialize all entries as 0.
        int[] least_prime = new int[n + 1];

        // We need to print 1 for 1.
        least_prime[1] = 1;

        for (int i = 2; i <= n; i++) {

            // least_prime[i] == 0
            // means it i is prime
            if (least_prime[i] == 0) {

                // marking the prime number
                // as its own lpf
                least_prime[i] = i;

                // mark it as a divisor for all its
                // multiples if not already marked
                for (int j = i * i; j <= n; j += i)
                    if (least_prime[j] == 0)
                        least_prime[j] = i;
            }
        }

        // print least prime factor of
        // of numbers till n
        return least_prime;
    }

    public static void main(String[] args) {
        int N = 50;
        int[] results = findSmallestPrimeFactors(N);
        PrintUtils.print1DArray(results);
        PrintUtils.printNewLine();
        results = leastPrimeFactor(N);
        PrintUtils.print1DArray(results);
    }
}
