package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers;

import com.scaler.core.utils.PrintUtils;
import com.scaler.core.utils.TimeDateUtils;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * @created 22/02/23 10:05 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion2 {
    /**
     * Question 2:
     * Given N, print all the prime numbers from 1 to N.
     * **/
    /**
     * Idea 1:
     * printAllPrimes
     * @param n
     */
    private static void printAllPrimes(int n) {
        for (int i = 0; i <= n; i++) {
            if (checkPrime(i)) {
                System.out.print(i +", ");
            }
        }
    }
    private static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Idea 2:
     * @param n
     */
    private static void printAllPrimes1(int n) {
        boolean[] primes = new boolean[n + 1];
        // Mark every index as true
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 0; i <= n; i++) {
            // Need to iterate on multiples only when i is prime
            if (primes[i]) { // primes[i] is prime
                for (int j = 2 * i; j <= n; j = j + i) {
                    // iterate for multiples of i
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * Idea 3: Sieve of Eratosthenes
     * @param n
     */
    private static void printAllPrimes2(int n) {
        boolean[] primes = new boolean[n + 1];
        // Mark every index as true
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            // We need to iterate on multiples only when primes[i] is prime true
            if (primes[i] == true) { // if primes[i] is prime
                // iterate for multiple of i
                for (int j = i * i; j <= n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + ", ");
            }
        }
    }
    public static void main(String[] args) {
        int N = 100;
        LocalTime start = TimeDateUtils.startTime();
        printAllPrimes(N);
        LocalTime end = TimeDateUtils.endTime();
        PrintUtils.printNewLine();
        TimeDateUtils.executeTime(start, end);

        PrintUtils.printNewLine();

        LocalTime start1 = TimeDateUtils.startTime();
        printAllPrimes1(N);
        LocalTime end1 = TimeDateUtils.endTime();
        PrintUtils.printNewLine();
        TimeDateUtils.executeTime(start1, end1);

        PrintUtils.printNewLine();

        LocalTime start2 = TimeDateUtils.startTime();
        printAllPrimes2(N);
        LocalTime end2 = TimeDateUtils.endTime();
        PrintUtils.printNewLine();
        TimeDateUtils.executeTime(start2, end2);
    }
}
