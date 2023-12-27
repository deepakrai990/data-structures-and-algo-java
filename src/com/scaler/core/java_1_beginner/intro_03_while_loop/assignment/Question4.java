package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:23 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question4 {
    /**
     * Q4. Even Game
     * Problem Description
     *
     * Write a program to print all even numbers from 1 to N where you have to take N as input from user.
     *
     * Strictly use while loop.
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
     * All even numbers from 1 to N separated by spaces.
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
     * 2 4
     * Output 2:
     *
     * 2 4 6 8 10
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int i = 2;
        while (i <= N) {
            System.out.print(i + " ");
            i = i + 2;
        }
    }
}
