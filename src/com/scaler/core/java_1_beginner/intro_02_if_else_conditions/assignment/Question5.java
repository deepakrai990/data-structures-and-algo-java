package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.assignment;

import java.util.Scanner;

/**
 * @created 23/07/22 1:59 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Problem Description
     * Write a program to input three numbers(A, B & C) from user and print the maximum element among A, B & C in each line.
     *
     *
     *
     * Problem Constraints
     * 1 <= A <= 1000000
     *
     * 1 <= B <= 1000000
     *
     * 1 <= C <= 1000000
     *
     *
     *
     * Input Format
     * First line is a single integer A.
     * Second line is a single integer B.
     * Third line is a single integer C.
     *
     *
     *
     * Output Format
     * One line containing an integer as per the question.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 5
     * 6
     * 7
     * Input 2:
     *
     * 1000
     * 10000
     * 100000
     *
     *
     * Example Output
     * Output 1:
     *
     * 7
     * Output 2:
     *
     * 100000
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Clearly, among 5, 6 and 7, 7 is maximum.
     * Explanation 2:
     *
     * Clearly, among 1000, 10000 and 100000, 100000 is maximum.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();

        if(A > B && A > C) {
            System.out.print(A);
        } else if(B > A && B > C) {
            System.out.print(B);
        } else {
            System.out.print(C);
        }
    }
}
