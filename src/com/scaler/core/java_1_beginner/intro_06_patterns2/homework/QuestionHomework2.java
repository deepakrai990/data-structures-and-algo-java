package com.scaler.core.java_1_beginner.intro_06_patterns2.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:23 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    /**
     * Q2. Different Pattern
     *
     * Problem Description
     * Given an integer N, print the corresponding Full Numeric Pyramid pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     * 0 0 0 0 5 0 0 0 0
     * 0 0 0 4 8 12 0 0 0
     * 0 0 3 6 9 12 15 0 0
     * 0 2 4 6 8 10 12 14 0
     * 1 2 3 4 5 6 7 8 9
     * If the row is considered as i, the value of i for the top-most row will be 1 and then 2, 3, ...., N subsequently for remaining rows and the values of pyramid are decided as (N-i) * (number of non-zero values printed before + 1).
     *
     * NOTE: There should be exactly one extra space after each number for each row.
     *
     *
     *
     * Problem Constraints
     * 2 <= N <= 100
     *
     *
     *
     * Input Format
     * First and only line of input contains a single integer N.
     *
     *
     *
     * Output Format
     * Output the Full Pyramid pattern corresponding to the given N.
     *
     * NOTE:
     *
     * There is no extra space before the first integer of any row.
     * There is an extra space after the last integer of any row.
     * All the integers in any row are space separated.
     *
     *
     * Example Input
     * Input 1:
     *
     * 2
     * Input 2:
     *
     * 3
     *
     *
     * Example Output
     * Output 1:
     *
     * 0 2 0
     * 1 2 3
     * Output 2:
     *
     * 0 0 3 0 0
     * 0 2 4 6 0
     * 1 2 3 4 5
     *
     *
     * Example Explanation
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int r = 1; r <= n; r++) {
            int zeroCount = n - r;
            int digitCount = 2 * r - 1;
            for(int zero = 1; zero <= zeroCount; zero++) {
                System.out.print("0 ");
            }
            for(int digit = 1; digit <= digitCount; digit++) {
                System.out.print((n - r + 1) * digit + " ");
            }
            for(int zero = 1; zero <= zeroCount; zero++) {
                System.out.print("0 ");
            }
            System.out.println();
        }
        in.close();
    }
}
