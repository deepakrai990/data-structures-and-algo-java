package com.scaler.core.java_1_beginner.intro_05_patterns1.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 7:39 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Print a matrix of stars
     *
     * Problem Description
     * Given two integers N and M, print a rectangle of N * M stars.
     *
     * For example if N = 3, M = 4 then pattern will be like:
     *
     * ****
     * ****
     * ****
     *
     *
     * Problem Constraints
     * 2 <= N, M <= 100
     *
     *
     *
     * Input Format
     * First line of input contains an integers N (no of rows).
     *
     * Second line of input contains an integer M (no of cols).
     *
     *
     *
     * Output Format
     * Output N * M rectangle of stars.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  2
     *  3
     * Input 2:
     *
     *  3
     *  1
     *
     *
     * Example Output
     * Output 1:
     *
     * ***
     * ***
     * Output 2:
     *
     * *
     * *
     * *
     *
     *
     * Example Explanation
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
