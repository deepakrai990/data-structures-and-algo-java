package com.scaler.core.java_1_beginner.intro_05_patterns1.homework;

import java.util.Scanner;

/**
 * @created 30/07/22 12:47 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework5 {
    /**
     * Q5. Photo Frame Pattern
     *
     * Problem Description
     * Given an integer N, print the corresponding pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     * *****
     * *___*
     * *___*
     * *___*
     * *****
     * Note : Here '_' represents space for explanation purpose only. You have to print space in your code.
     *
     *
     * Problem Constraints
     * 3 <= N <= 100
     *
     *
     *
     * Input Format
     * First and only line of input contains a single integer N.
     *
     *
     *
     * Output Format
     * Output the pattern corresponding to the given N.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  3
     * Input 2:
     *
     *  4
     *
     *
     * Example Output
     * Output 1:
     *
     * ***
     * *_*
     * ***
     * Output 2:
     *
     *
     * ****
     * *__*
     * *__*
     * ****
     * Note : Here '_' represents space for explanation purpose only. You have to print space in your code.
     *
     *
     * Example Explanation
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 || i == N || j == 1 || j == N) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
