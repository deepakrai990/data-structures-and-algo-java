package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:18 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question1 {
    /**
     * Q1. From top to down
     * Problem Description
     *
     * Write a program to print all Natural numbers from 1 to N where you have to take N as input from user
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 10000000
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
     * N space separated integers from 1 to N.
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
     * 1 2 3 4 5
     * Output 2:
     *
     * 1 2 3 4 5 6 7 8 9 10
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 1;
        while (i <= N) {
            System.out.print(i + " ");
            i = i + 1;
        }
        input.close();
    }
}
