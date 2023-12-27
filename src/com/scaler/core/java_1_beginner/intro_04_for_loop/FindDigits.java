package com.scaler.core.java_1_beginner.intro_04_for_loop;

import java.util.Scanner;

/**
 * @created 28/07/22 10:54 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class FindDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        System.out.println("--------------------------");
        findDigit(N);
        System.out.println("--------------------------");
        findDigit1(N);
        System.out.println("--------------------------");
        findSumOfLastDigits(N);
        System.out.println("--------------------------");
    }

    public static void findDigit(int N) {
        while (N > 0) {
            int lastDigit = N % 10;
            System.out.println(lastDigit);
            N = N / 10;
        }
    }
    public static void findDigit1(int N) {
        if (N == 0) {
            System.out.println(0);
        } else {
            if (N < 0) {
                N = N * (-1);
            }
            while (N > 0) {
                int lastDigit = N % 10;
                System.out.println(lastDigit);
                N = N / 10;
            }
        }
    }
    private static void findSumOfLastDigits(int N) {
        int sum = 0;
        while (N > 0) {
            int lastDigit = N % 10;
            sum += lastDigit;
            N /= 10;
        }
        System.out.println("sum = " + sum);
    }
}
