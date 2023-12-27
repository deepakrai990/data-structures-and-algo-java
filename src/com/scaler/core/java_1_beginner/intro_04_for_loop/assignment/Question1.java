package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 12:48 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. First vs Last
     * Problem Description
     * Write a program to input T numbers(N) from user and print first and last digits of the given numbers.
     *
     *
     *
     * Problem Constraints
     * 1 <= T <= 1000
     *
     * 0 <= N <= 100000000
     *
     *
     *
     * Input Format
     * First line is T which means number of test cases.
     *
     * Each next T lines contain an integer N.
     *
     *
     *
     * Output Format
     * T lines each containing two space separated integers representing first and last digits of the input integer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 2
     * 5
     * 1001
     * Input 2:
     *
     * 2
     * 10023
     * 1589
     *
     *
     * Example Output
     * Output 1:
     *
     * 5 5
     * 1 1
     * Output 2:
     *
     * 1 3
     * 1 9
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * 5 has fist and last digits same.
     * 1001 also has fist and last digits same.
     * Explanation 2:
     *
     * 10023 has 1 as first digit and 3 as last digit.
     * 1589 has 1 as first digit and 9 as last digit.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for(int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int lastDigit = N % 10;
            int firstDigit = N;
            while(firstDigit >= 10)
                firstDigit = firstDigit / 10;
            System.out.println(firstDigit + " " + lastDigit);
        }
    }
}
