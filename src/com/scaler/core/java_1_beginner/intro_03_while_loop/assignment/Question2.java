package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:18 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question2 {
    /**
     * Q2. Odd Game
     * Problem Description
     *
     * Write a program to print all odd numbers from 1 to N where you have to take N as input from user.
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 1000000
     *
     *
     *
     * Input Format
     *
     * A single line representing N
     *
     *
     *
     *
     * Output Format
     *
     * All odd numbers from 1 to N separated by spaces.
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
     * 1 3 5
     * Output 2:
     *
     * 1 3 5 7 9
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 1;
        while (i <= N) {
            System.out.print(i + " ");
            i = i + 2;
        }
    }
}
