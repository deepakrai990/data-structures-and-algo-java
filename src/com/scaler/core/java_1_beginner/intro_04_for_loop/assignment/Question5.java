package com.scaler.core.java_1_beginner.intro_04_for_loop.assignment;

import java.util.Scanner;

/**
 * @created 28/07/22 5:47 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. Count the digits
     *
     * Problem Description
     *
     * Mr. Q has a diary in which he has written a lot of numbers. He is confused with the number of digits in every number. Ask Mr. Q about the total different numbers written in the diary and then write a code to find the number of digits in every number.
     *
     * Note : Total different Numbers are T and for every number (let's say N) you need to find the total number of digits.
     *
     *
     * Problem Constraints
     *
     * 1 <= T <= 100
     *
     * 0 <= N <= 100000000
     *
     *
     *
     * Input Format
     *
     * First line is T which means total number written in diary.
     *
     * Next T lines contain an integer N.
     *
     *
     *
     * Output Format
     *
     * For T different Numbers, Print number of digits in T different lines.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 2
     * 0
     * 1
     * Input 2:
     *
     * 2
     * 100
     * 10101
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 1
     * 1
     * Output 2:
     *
     * 3
     * 5
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * 0 and 1 both have only one digit.
     * Explanation 2:
     *
     * 100 has three digits and 10101 has 5 digits.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int b = 1; b <= T; b++) {
            int N = in.nextInt();
            int noOfDigits = 0;
            if(N == 0) {
                noOfDigits++;
            }
            while (N > 0) {
                noOfDigits++;
                N /= 10;
            }
            System.out.println(noOfDigits);
        }
    }
}
