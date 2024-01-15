package com.scaler.core.java_2_intermediate.dsa_01_intro_to_problem_solving;

import com.scaler.core.utils.PrintUtils;

/**
 * @author Deepak Kumar Rai
 * @created 30/12/23
 * @project scaler_course_code
 */
public class Q2_Prime_Numbers {
    /*
    * Prime Numbers
    * */
    private static boolean isPrime(int N) {
        return countFactors(N) == 2;
    }
    private static int countFactors(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    // Optimise One
    private static boolean isPrime1(int N) {
        return countFactors1(N) == 2;
    }
    private static int countFactors1(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (count >= 3) {
                return count;
            }
            if (N % i == 0) {
                if (i == N / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
    // Function to check whether a number is prime
    private static boolean isPrime2(int number) {
        // Base cases
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (number == 2 || number == 3) {
            return true; // 2 and 3 are prime numbers
        }

        // Optimized checks for divisibility by 2 and 3
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Numbers divisible by 2 or 3 are not prime
        }

        // Iterate from 5 to the square root of the number
        int sqrtNumber = (int) Math.sqrt(number) + 1;
        for (int i = 5; i <= sqrtNumber; i += 6) {
            // Check for divisibility by (6k ± 1)
             System.out.println(number + " % " + i + " == " + (number % i)
                    + " || " + number + " % " + (i + 2) + " == " + (number % (i + 2)));
            if (number % i == 0 || number % (i + 2) == 0) {
                return false; // The number is not prime
            }
        }

        // If no divisors are found, the number is prime
        return true;
    }
    public static void main(String[] args) {
        int N = 197;

        boolean result = isPrime(N);
        PrintUtils.print(N +" is "+ (result ? "Prime" : "not a prime"));

        result = isPrime1(N);
        PrintUtils.print(N +" is "+ (result ? "Prime" : "not a prime"));

        result = isPrime2(N);
        PrintUtils.print(N +" is "+ (result ? "Prime" : "not a prime"));
    }
}
