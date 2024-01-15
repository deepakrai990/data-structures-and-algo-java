package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 2:33 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6Solution {

    public static int reverse(int A) {
        int reverse = A;
        int sign = 1;
        if (A < 0) {
            A *= -1;
            sign = -1;
        }
        reverse = reverseOf(A);
        if (reverse == Integer.MIN_VALUE)
            return 0;
        reverse *= sign;
        return reverse;
    }

    public static int reverseOf(int num) {
        int newNum = 0;
        while (num > 0) {
            int digit = num % 10;
            if (newNum > Integer.MAX_VALUE / 10 || ((newNum == Integer.MAX_VALUE / 10)
                    && digit > Integer.MAX_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            newNum = newNum * 10 + digit;
            num /= 10;
        }
        return (int) newNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        System.out.println("A========= " + A);
        int result = reverse(A);
        System.out.println(result);
        in.close();
    }
}
