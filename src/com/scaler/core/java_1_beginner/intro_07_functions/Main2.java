package com.scaler.core.java_1_beginner.intro_07_functions;

import java.util.ArrayList;

/**
 * @created 04/08/22 3:04 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main2 {
    static int MAX = 10000;

    static ArrayList<Integer> primes = new ArrayList<Integer>();

    static void sieveSundaram() {
        boolean[] marked = new boolean[MAX / 2 + 100];

        for (int i = 1; i <= (Math.sqrt(MAX) - 1) / 2; i++)
            for (int j = (i * (i + 1)) << 1; j <= MAX / 2; j = j + 2 * i + 1)
                marked[j] = true;
        primes.add(2);
        for (int i = 1; i <= MAX / 2; i++)
            if (marked[i] == false)
                primes.add(2 * i + 1);
    }

    // Function to perform Goldbach's conjecture
    static void findPrimes(int n) {
        if (n <= 2 || n % 2 != 0) {
            return;
        }
        for (int i = 0; primes.get(i) <= n / 2; i++) {
            int diff = n - primes.get(i);

            if (primes.contains(diff)) {
                System.out.println(primes.get(i) +
                        " + " + diff + " = " + n);
                return;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Finding all prime numbers before limit
        sieveSundaram();

        // Express number as a sum of two primes
        findPrimes(16777214);
        //findPrimes(10);
        //findPrimes(100);
    }
}
