package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.assignment;

import java.util.Scanner;

/**
 * @created 23/07/22 1:59 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Problem Description
     *
     * You are given an integer A.
     *
     * You have to tell how many days are there in the month denoted by A in a non-leap year.
     *
     * Months are denoted as follows:
     *
     * January : 1
     * February : 2
     * March : 3
     * April : 4
     * May : 5
     * June : 6
     * July : 7
     * August : 8
     * September : 9
     * October : 10
     * November : 11
     * December : 12
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
     * The input contains a single integer A.
     *
     *
     *
     * Output Format
     *
     * Print a single integer denoting the number of days on a single line.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  1
     * Input 2:
     *
     *  11
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  31
     * Output 2:
     *
     *  30
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Number of days in January(1) in a non-leap year = 31.
     * Explanation 2:
     *
     *  Number of days in November(11) in a non-leap year = 30.
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int noOfDays = 0;
        if(A == 1) {
            noOfDays = 31;
        } else if (A == 2) {
            noOfDays = 28;
        } else if (A == 3) {
            noOfDays = 31;
        } else if (A == 4) {
            noOfDays = 30;
        } else if (A == 5) {
            noOfDays = 31;
        } else if (A == 6) {
            noOfDays = 30;
        } else if (A == 7) {
            noOfDays = 31;
        } else if (A == 8) {
            noOfDays = 31;
        } else if (A == 9) {
            noOfDays = 30;
        } else if (A == 10) {
            noOfDays = 31;
        } else if (A == 11) {
            noOfDays = 30;
        } else if (A == 12) {
            noOfDays = 31;
        }
        System.out.print(noOfDays);
    }
}
