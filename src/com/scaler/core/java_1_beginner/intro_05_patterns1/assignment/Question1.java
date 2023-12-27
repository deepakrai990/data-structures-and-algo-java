package com.scaler.core.java_1_beginner.intro_05_patterns1.assignment;

import java.util.Scanner;

/**
 * @created 06/08/22 7:38 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. Print N stars
     *
     * Problem Description
     * Given an integer N, print N stars in a single line.
     *
     * For example if N = 5 then pattern will be like:
     *
     * *****
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
     * Output N stars in a single line.
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
     * Output 2:
     *
     * ***
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
        }
    }
}
