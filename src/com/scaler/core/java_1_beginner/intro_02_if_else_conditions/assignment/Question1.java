package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.assignment;

import java.util.Scanner;

/**
 * @created 23/07/22 1:59 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Problem Description
     *
     * Write a program to input an integer(A) from user and print the Ath month of the year.
     *
     * Months list: {January, February, March, April, May, June, July, August, September, October, November, December}
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= A <= 12
     *
     *
     *
     * Input Format
     *
     * One line containing an integer integer A.
     *
     *
     *
     * Output Format
     *
     * One line containing the Ath month of the year.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 1
     * Input 2:
     *
     * 6
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * January
     * Output 1:
     *
     * June
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     * Clearly, January is the 1st month.
     * Explanation 2:
     *
     * Clearly, June is the 6th month.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        if(A == 1) {
            System.out.print("January");
        } else if (A == 2) {
            System.out.print("February");
        } else if (A == 3) {
            System.out.print("March");
        } else if (A == 4) {
            System.out.print("April");
        } else if (A == 5) {
            System.out.print("May");
        } else if (A == 6) {
            System.out.print("June");
        } else if (A == 7) {
            System.out.print("July");
        } else if (A == 8) {
            System.out.print("August");
        } else if (A == 9) {
            System.out.print("September");
        } else if (A == 10) {
            System.out.print("October");
        } else if (A == 11) {
            System.out.print("November");
        } else if (A == 12) {
            System.out.print("December");
        }
    }
}
