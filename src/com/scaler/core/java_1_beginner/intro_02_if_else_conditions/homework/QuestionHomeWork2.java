package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 2:49 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork2 {
    /**
     * Problem Description
     * Write a program to input an integer from user and print 1 if it is odd otherwise print 0.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 1000000
     *
     *
     *
     * Input Format
     * One line containing an integer N.
     *
     *
     *
     * Output Format
     * Print either 1 or 0 as per the question.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * 5
     * Input 2:
     *
     * 1000
     *
     *
     * Example Output
     * Output 1:
     *
     * 1
     * Output 2:
     *
     * 0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Clearly, 5 is odd.
     * Explanation 2:
     *
     * Clearly, 1000 is even.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        if(A % 2 == 0) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }
    }
}
