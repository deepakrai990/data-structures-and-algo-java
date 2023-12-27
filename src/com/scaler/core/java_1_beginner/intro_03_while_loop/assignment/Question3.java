package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:21 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. Summation Game
     * Problem Description
     *
     * Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000
     *
     *
     *
     * Input Format
     *
     * A single line representing N
     *
     *
     *
     * Output Format
     *
     * A single integer showing sum of all Natural numbers from 1 to N
     *
     *
     *
     * Example Input
     *
     * Input 1:
     *
     * 5
     * Input 2:
     *
     * 10
     *
     *
     * Example Output
     *
     * Output 1:
     *
     * 15
     * Output 2:
     *
     * 55
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 1;
        int total = 0;
        while (i <= N) {
            total = total + i;
            i = i + 1;
        }
        System.out.print(total);
    }
}
