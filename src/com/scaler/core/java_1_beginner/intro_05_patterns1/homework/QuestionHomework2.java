package com.scaler.core.java_1_beginner.intro_05_patterns1.homework;

import java.util.Scanner;

/**
 * @created 06/08/22 7:43 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomework2 {
    /**
     * Q2. Inverted Half Pyramid
     *
     * Problem Description
     *
     * Given an integer N, print the corresponding Inverted Half Pyramid pattern for N.
     *
     * For example if N = 4 then pattern will be like:
     *
     * ****
     * ***
     * **
     * *
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
     * Output the Inverted Half Pyramid pattern corresponding to the given N.
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
     *  **
     *  *
     * Output 2:
     *
     *  ***
     *  **
     *  *
     *
     *
     * Example Explanation
     *
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= N - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }
}
