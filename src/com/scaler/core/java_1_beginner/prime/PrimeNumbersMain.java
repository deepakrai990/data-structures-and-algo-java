package com.scaler.core.java_1_beginner.prime;

import java.util.Scanner;

/**
 * @created 21/07/22 7:37 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class PrimeNumbersMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        System.out.println(isPrime(A));
        System.out.println(isPrime1(A));
        input.close();
    }

    public static boolean isPrime(int n) {
        for (int count = 2; count < n - 1; count++) {
            if (n % count == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime1(int n) {
        for (int count = 2; count < n / 2; count++) {
            if (n % count == 0)
                return false;
        }
        return true;
    }
}
