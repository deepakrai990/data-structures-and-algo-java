package com.scaler.core.java_1_beginner.intro_02_if_else_conditions.homework;

import java.util.Scanner;

/**
 * @created 23/07/22 3:15 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class QuestionHomeWork8 {
    /**
     * Problem Description
     *
     * You are given the Cost Price C and Selling Price S of a Product. You have to tell whether there is a
     * Profit or Loss. Also, calculate total profit or loss.
     *
     * NOTE: It is guaranteed that Cost Price and Selling Price are not equal.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= C, S <= 109
     *
     * C ≠ S
     *
     *
     *
     * Input Format
     *
     * First line of the input contains a single integer C.
     *
     * Second line of the input contains a single integer S.
     *
     *
     *
     * Output Format
     *
     * Print two integers in separate lines.
     *
     * First integer denotes whether there is a profit or loss. If there is a profit, print 1, else print -1.
     *
     * Second integer is a non-negative integer denoting the absolute value of total profit or loss.
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  2
     *  4
     * Input 2:
     *
     *  4
     *  1
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  1
     *  2
     * Output 2:
     *
     *  -1
     *  3
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Cost Price = 2
     *  Selling Price = 4
     *  As Cost Price < Selling Price, there is a profit.
     *  Total Profit = Selling Price - Cost Price = 4 - 2 = 2
     * Explanation 2:
     *
     *  Cost Price = 4
     *  Selling Price = 1
     *  As Cost Price > Selling Price, there is a loss.
     *  Total Loss = Cost Price - Selling Price = 4 - 1 = 3
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int C = input.nextInt();
        int S = input.nextInt();
        if (S > C) {
            System.out.println(1);
            System.out.println(S - C);
        } else if (S < C) {
            System.out.println(-1);
            System.out.println(C - S);
        }
    }
}
