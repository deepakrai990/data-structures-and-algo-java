package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_1.dsa_08_maths_3_prime_numbers;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 19/01/23 10:48 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class LiveClassQuestion1 {
    /**
     * Question 1:
     * Given a number, we need to check if it is prime or not?
     * **/
    /**
     * Idea 1:
     * @param n
     * @return
     */
    private static boolean checkPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) return true;
        return false;
    }

    /**
     * Idea 2:
     * @param n
     * @return
     */
    private static boolean checkPrime1(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        if (count == 2) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 24;
        boolean isPrime = checkPrime(n);
        PrintUtils.printBool(isPrime);
        PrintUtils.printNewLine();
        int n1 = 29;
        isPrime = checkPrime1(n1);
        PrintUtils.printBool(isPrime);
    }
}
