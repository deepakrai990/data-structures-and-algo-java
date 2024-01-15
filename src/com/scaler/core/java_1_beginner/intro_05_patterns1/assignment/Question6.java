package com.scaler.core.java_1_beginner.intro_05_patterns1.assignment;

import java.util.Scanner;

/**
 * @created 30/07/22 12:20 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question6 {
    /**
     * Q6. Inverted Numeric Pyramid
     *
     * Problem Description
     *
     * Given an integer N, print the corresponding Numeric Inverted Half Pyramid pattern for N.
     *
     * For example if N = 4 then pattern will be like:
     *
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 100
     *
     *
     *
     * Input Format
     *
     * First and only line of input contains a single integer N.
     *
     *
     *
     * Output Format
     *
     * Output the Numeric Inverted Half Pyramid pattern corresponding to the given N.
     *
     * NOTE: There should be no extra spaces after last integer and before first integer in any row and all integers in any row in the pattern are space separated.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     * Input 2:
     *
     *  3
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 1 2
     * 1
     * Output 2:
     *
     * 1 2 3
     * 1 2
     * 1
     *
     *
     * Example Explanation
     *
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        in.close();
    }
}
