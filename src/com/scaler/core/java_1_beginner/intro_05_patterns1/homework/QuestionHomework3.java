package com.scaler.core.java_1_beginner.intro_05_patterns1.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:44 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework3 {
    /**
     * Q3. Two Line Star Pattern
     *
     * Problem Description
     * Given an integer N, print the corresponding pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     * *___*
     * *___*
     * *___*
     * *___*
     * *___*
     * Note : Here '_' represents space for explanation purpose only. You have to print space in your code.
     *
     *
     * Problem Constraints
     * 1 <= N <= 100
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
     *  2
     * Input 2:
     *
     *  3
     *
     *
     * Example Output
     * Output 1:
     *
     * **
     * **
     * Output 2:
     *
     *
     *  *_*
     *  *_*
     *  *_*
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
            System.out.print("*");
            for(int j = 1; j < N - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        in.close();
    }
}
