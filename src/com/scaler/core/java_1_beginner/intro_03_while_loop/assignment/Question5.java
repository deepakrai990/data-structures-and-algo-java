package com.scaler.core.java_1_beginner.intro_03_while_loop.assignment;

import java.util.Scanner;

/**
 * @created 26/07/22 3:23 PM
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question5 {
    /**
     * Q5. From down to top
     * Problem Description
     *
     * Write a program to print all Natural numbers from N to 1 where you have to take N as input from user
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
     * N space separated integers from N to 1.
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
     * 5 4 3 2 1
     * Output 2:
     *
     * 10 9 8 7 6 5 4 3 2 1
     * **/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        while(N >= 1){
            System.out.print(N + " ");
            N = N - 1;
        }
        input.close();
    }
}
