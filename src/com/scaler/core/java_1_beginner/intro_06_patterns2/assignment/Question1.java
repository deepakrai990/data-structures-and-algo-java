package com.scaler.core.java_1_beginner.intro_06_patterns2.assignment;

import java.util.Scanner;

/**
 * @created 02/08/22 1:05 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Hollow inverted pyramid pattern
     *
     * Problem Description
     * Given an integer N, print the corresponding pattern for N.
     *
     * For example if N = 5 then pattern will be like:
     *
     * *________* // 8 spaces
     *
     * **______** // 6 spaces
     *
     * ***____*** // 4 spaces
     *
     * ****__**** // 2 spaces
     *
     * ********** // 0 spaces
     *
     * NOTE: Here '_' is used to represent spaces. You have to print spaces in your code.
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
     * *__* // 2 spaces
     *
     * **** // 0 spaces
     * Output 2:
     *
     * *____* // 4 spaces
     *
     * **__** // 2 spaces
     *
     * ****** // 0 spaces
     *
     *
     * Example Explanation
     *  Print the pattern as described.
     * **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int row = 1; row <= n; row++) {
            int starCount = row;
            int spaceCount = 2 * (n-row);
            for(int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }
            for(int space = 1; space <= spaceCount; space++) {
                System.out.print(" ");
            }
            for(int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }
}
