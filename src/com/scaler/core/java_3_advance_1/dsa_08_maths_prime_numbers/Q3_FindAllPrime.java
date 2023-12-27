package com.scaler.core.java_3_advance_1.dsa_08_maths_prime_numbers;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created 19/09/23 11:19 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_FindAllPrime {
    /**
     * Bruteforce Approach
     * **/
    private static int[] findAllPrime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Optimise Approach
     * **/
    private static int[] findAllPrimeOptimise(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int n = 50;
        int[] results = findAllPrime(n);
        PrintUtils.print1DArray(results);

        PrintUtils.printNewLine();

        results = findAllPrimeOptimise(n);
        PrintUtils.print1DArray(results);

    }
}
